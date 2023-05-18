package yogurrr.springboot.semiprojectv7.dao;

import org.springframework.stereotype.Repository;
import yogurrr.springboot.semiprojectv7.model.Member;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{
    @Override
    public int selectLogin(Member m) {
        return 0;
    }
}
