package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.Pds;
import yogurrr.springboot.semiprojectv7.model.PdsAttach;

public interface PdsDAO {

    int insertPds(Pds pds);

    int insertPdsAttach(PdsAttach pa);
}
