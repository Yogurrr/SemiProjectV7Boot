package yogurrr.springboot.semiprojectv7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import yogurrr.springboot.semiprojectv7.model.Board;
import yogurrr.springboot.semiprojectv7.model.GalAttach;
import yogurrr.springboot.semiprojectv7.model.Gallery;
import yogurrr.springboot.semiprojectv7.repository.GalleryRepository;
import yogurrr.springboot.semiprojectv7.repository.GalleryaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> selectGallery(Integer cpg) {
        // 페이징 시 저열 순서 지정
        Pageable paging = PageRequest.of(cpg, 25, Sort.by("gno").descending());

        Map<String, Object> gals = new HashMap<>();
        // Gallery와 GalAttach를 조인해서 리스트로 가져옴
        gals.put("gallist", galarepo.findAllBy(paging).getContent());
        gals.put("cntpg", galarepo.findAllBy(paging).getTotalPages());

        return gals;
    }
}
