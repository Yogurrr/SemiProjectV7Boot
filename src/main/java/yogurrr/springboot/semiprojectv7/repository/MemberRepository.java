package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 로그인 처리 1
    // Member findByUseridAndPasswd(String userid, String passwd);

    // 로그인 처리 2
    int countByUseridAndPasswd(String userid, String passwd);
}
