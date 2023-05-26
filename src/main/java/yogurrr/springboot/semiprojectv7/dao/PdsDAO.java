package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.Pds;
import yogurrr.springboot.semiprojectv7.model.PdsAttach;
import yogurrr.springboot.semiprojectv7.model.PdsReply;

import java.util.List;
import java.util.Map;

public interface PdsDAO {

    int insertPds(Pds pds);

    int insertPdsAttach(PdsAttach pa);

    Map<String, Object> selectPds(int cpg);

    Pds selectOnePds(int pno);

    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<String> selectFtypes();

    List<PdsReply> selectPdsReply(int pno);

    int insertReply(PdsReply reply);
}
