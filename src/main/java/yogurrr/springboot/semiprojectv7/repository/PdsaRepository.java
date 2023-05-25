package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.PdsAttach;

import javax.transaction.Transactional;

public interface PdsaRepository extends JpaRepository<PdsAttach, Long> {
    PdsAttach findByPno(int pno);

    @Transactional
    @Modifying
    @Query("update PdsAttach set fdown = fdown + 1 where pno = :pno")
    void countDownByPno(@Param("pno") int pno);
}
