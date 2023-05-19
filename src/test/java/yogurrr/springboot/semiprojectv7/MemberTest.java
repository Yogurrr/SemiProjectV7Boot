package yogurrr.springboot.semiprojectv7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yogurrr.springboot.semiprojectv7.model.Member;
import yogurrr.springboot.semiprojectv7.repository.MemberRepository;

import java.util.List;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("showall")
    public void findAllMember() {
        List<Member> mbs = memberRepository.findAll();

        System.out.println(mbs);
    }

    @Test
    @DisplayName("member save")
    public void saveMember() {
        Member m = new Member(null, "aaa111", "123456", "1234567", "aaa111",
                "aaa111", "123-456", "서울시", "ㅇㅇ", "aaa111@gmail.com",
                "123-456-789", null);

        memberRepository.save(m);
    }

    @Test
    @DisplayName("member update")
    public void updateMember() {
        Member m = new Member(3L, "kkk999", "123456", "1234567", "kkk999",
                "kkk999", "789-456", "대전시", "ㅁㅁ", "kkk999@naver.com",
                "000-0000-0000", null);

        memberRepository.save(m);
    }

    @Test
    @DisplayName("member delete")
    public void deleteMember() {
        Member m = new Member();
        m.setMbno(4L);

        memberRepository.delete(m);
    }
}
