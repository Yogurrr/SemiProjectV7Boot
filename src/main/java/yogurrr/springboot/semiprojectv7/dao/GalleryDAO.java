package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.GalAttach;
import yogurrr.springboot.semiprojectv7.model.Gallery;

public interface GalleryDAO {
    int insertGal(Gallery gallery);

    int insertGalAttach(GalAttach ga);
}
