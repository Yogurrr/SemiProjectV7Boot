package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.GalAttach;
import yogurrr.springboot.semiprojectv7.model.Gallery;

import java.util.Map;

public interface GalleryDAO {
    int insertGal(Gallery gallery);

    int insertGalAttach(GalAttach ga);

    Map<String, Object> selectGallery(Integer cpg);

    Object selectOneGallery(int gno);
}
