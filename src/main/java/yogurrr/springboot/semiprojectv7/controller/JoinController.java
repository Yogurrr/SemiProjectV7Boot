package yogurrr.springboot.semiprojectv7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import yogurrr.springboot.semiprojectv7.model.Member;
import yogurrr.springboot.semiprojectv7.service.JoinService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService jnsrv;

    @GetMapping("/agree")
    public String agree() {
        return "join/agree";
    }

    @GetMapping("/checkme")
    public String checkme() {
        return "join/checkme";
    }

    @PostMapping("/joinme")
    public ModelAndView joinme(Member mb) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("join/joinme");
        mv.addObject("mb", mb);

        return mv;
    }

    @PostMapping("/joinok")
    public String joinok(Member m, String grecaptcha) {
        String view = "/error";

        if (jnsrv.newMember(m)) {
            view = "join/joinok";
        }

        return view;
    }

    // 우편번호 검색
    // /join/zipcode?dong=동이름
    // 검색결과는 뷰페이지 없이 바로 응답으로 출력 : RESTful 방식
    // 서블릿에서 제공하는 HttpServletResponse 객체를 이용하면
    // 스프링의 뷰리졸버 없이 바로 응답으로 출력할 수 있음
    // 단, 응답유형은 JSON 형식으로 함
    @ResponseBody
    @GetMapping("/zipcode")
    public void zipcode(String dong, HttpServletResponse res) {
        try {
            // 응답유형은 JSON으로 설정
            res.setContentType("application/json; charset=UTF-8");
            // 검색된 우편번호 결과를 응답
            res.getWriter().print(jnsrv.findZipcode(dong));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 아이디 사용 가능 여부 검사
    // /join/checkuid?uid=아이디
    // 사용 가능     : 0
    // 사용 불가능   : 1
    @ResponseBody
    @GetMapping("/checkuid")
    public void checkuid(String uid, HttpServletResponse res) {
        try {
            // 아이디 사용 여부를 뷰 없이 바로 응답으로 출력
            res.getWriter().print(jnsrv.checkUserid(uid));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
