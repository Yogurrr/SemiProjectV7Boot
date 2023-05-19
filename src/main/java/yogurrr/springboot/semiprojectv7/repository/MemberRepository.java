package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.Member;
import yogurrr.springboot.semiprojectv7.model.Zipcode;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
