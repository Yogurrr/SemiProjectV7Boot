package yogurrr.springboot.semiprojectv7.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import yogurrr.springboot.semiprojectv7.model.GalAttach;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("galUtils")
public class GalleryUtils {
    // 첨부파일 저장 위치
    @Value("${saveImgDir}") private String saveImgDir;

    public String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
        uuid = uuid.replace("-", "").replace(":", "").replace(".", "");

        return uuid;
    }

    public GalAttach processUpload(List<MultipartFile> attachs, Map<String, Object> ginfo) {

        // 이미지 첨부파일명과 사이즈는 먼저 리스트로 저장한 뒤 문자열로 변환
        // 업로드할 파일 정보 취득
        GalAttach ga = new GalAttach();
        ga.setGno((Integer) ginfo.get("gno"));
        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        // 첨부된 파일들에 대한 반복 처리
        for (MultipartFile attach : attachs) {
            String fname = attach.getOriginalFilename();

            // 파일 유형과
            int pos = fname.lastIndexOf(".") + 1;
            String ext = fname.substring(pos);
            String fsize = (attach.getSize() / 1024) + "";

            // 저장 시 사용할 파일이름 생성
            // 파일이름 형식 : 파일이름UUID.확장자
            String savefname = fname.substring(0, pos - 1);
            String fullname = savefname + ginfo.get("uuid") + "." + ext;
            savefname = saveImgDir + fullname;

            try {
                // 첨부파일을 파일시스템에 저장
                attach.transferTo(new File(savefname));

                // 첨부파일 정보를 리스트에 저장
                fnames.add(fullname);   // 파일이름UUID.확장자
                fnames.add(fsize);
                System.out.println(fname + "," + fsize + "," + savefname);

            } catch (Exception ex) {
                System.out.println("업로드 중 오류 발생");
                ex.printStackTrace();
            }
        }   // for

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트 변수) : 요소1;요소2;요소3
        ga.setFname(String.join(";", fnames));
        ga.setFsize(String.join(";", fsizes));
        System.out.println(ga.getFname() + " " + ga.getFsize());

        return ga;
    }

    public void makeThumbnail(GalAttach ga, Object uuid) {
    }
}
