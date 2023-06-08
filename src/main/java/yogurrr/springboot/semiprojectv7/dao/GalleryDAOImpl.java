package yogurrr.springboot.semiprojectv7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yogurrr.springboot.semiprojectv7.model.GalAttach;
import yogurrr.springboot.semiprojectv7.model.Gallery;
import yogurrr.springboot.semiprojectv7.repository.GalleryRepository;
import yogurrr.springboot.semiprojectv7.repository.GalleryaRepository;

@Repository("galdao")
public class GalleryDAOImpl implements GalleryDAO{

    // 생성자를 이용한 스프링 빈 주입
    private final GalleryRepository galrepo;
    private final GalleryaRepository galarepo;

    @Autowired
    public GalleryDAOImpl(GalleryRepository galrepo, GalleryaRepository galarepo) {
        this.galrepo = galrepo;
        this.galarepo = galarepo;
    }

    @Override
    public int insertGal(Gallery gallery) {
        return Math.toIntExact(galrepo.save(gallery).getGno());
    }

    @Override
    public int insertGalAttach(GalAttach ga) {
        return Math.toIntExact(galarepo.save(ga).getGano());
    }
}
