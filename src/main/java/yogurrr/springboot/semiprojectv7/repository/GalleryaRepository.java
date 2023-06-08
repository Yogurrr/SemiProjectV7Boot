package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.GalAttach;

import javax.transaction.Transactional;
import java.util.List;

public interface GalleryaRepository extends JpaRepository<GalAttach, Long> {
    //
}
