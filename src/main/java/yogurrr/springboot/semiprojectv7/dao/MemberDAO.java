package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.Member;

public interface MemberDAO {
    int selectLogin(Member m);
}
