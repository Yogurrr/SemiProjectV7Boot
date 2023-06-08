package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.Gallery;

import javax.transaction.Transactional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    @Modifying
    @Transactional
    @Query("update Gallery set views = views + 1 where gno = :gno")
    void countViewById(@Param("gno") long gno);
}
