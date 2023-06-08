package yogurrr.springboot.semiprojectv7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yogurrr.springboot.semiprojectv7.dao.GalleryDAO;
import yogurrr.springboot.semiprojectv7.model.GalAttach;
import yogurrr.springboot.semiprojectv7.model.Gallery;
import yogurrr.springboot.semiprojectv7.utils.GalleryUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("galsrv")
public class GalleryServiceImpl implements GalleryService{

    @Autowired
    GalleryDAO galdao;

    @Autowired
    GalleryUtils galUtils;

    @Override
    public Map<String, Object> newGallery(Gallery gallery) {
        gallery.setUuid(galUtils.makeUUID());
        int gno = galdao.insertGal(gallery);

        Map<String, Object> ginfo = new HashMap<>();
        ginfo.put("gno", gno);
        ginfo.put("uuid", gallery.getUuid());

        return ginfo;
    }

    @Override
    public boolean newPdsAttach(List<MultipartFile> attachs, Map<String, Object> ginfo) {
        // 이미지 파일 저장
        GalAttach ga = galUtils.processUpload(attachs, ginfo);

        // 썸네일 이미지 생성
        galUtils.makeThumbnail(ga, ginfo.get("uuid"));

        // 첨부정보 디비 저장
        int gano = galdao.insertGalAttach(ga);

        return (gano > 0) ? true : false;
    }

    @Override
    public Map<String, Object> readGallery(Integer cpg) {
        return galdao.selectGallery(cpg - 1);
    }
}
