package yogurrr.springboot.semiprojectv7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import yogurrr.springboot.semiprojectv7.model.Board;
import yogurrr.springboot.semiprojectv7.model.Pds;
import yogurrr.springboot.semiprojectv7.model.PdsAttach;
import yogurrr.springboot.semiprojectv7.repository.PdsRepository;
import yogurrr.springboot.semiprojectv7.repository.PdsaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("pdsdao")
public class PdsDAOImpl implements PdsDAO{

    @Autowired
    PdsRepository pdsRepository;

    @Autowired
    PdsaRepository pdsaRepository;

    @Override
    public int insertPds(Pds pds) {
        // 제목, 작성자, 본문을 pds 테이블에 저장한 뒤
        // 저장 시 생성된 pno를 리턴함
        return Math.toIntExact(pdsRepository.save(pds).getPno());
    }

    @Override
    public int insertPdsAttach(PdsAttach pa) {
        return Math.toIntExact(pdsaRepository.save(pa).getPano());
    }

    @Override
    public Map<String, Object> selectPds(int cpg) {
        Pageable paging = PageRequest.of(cpg, 25, Sort.by("pno").descending());

        Map<String, Object> pds = new HashMap<>();
        pds.put("pdslist", pdsRepository.findAll(paging).getContent());
        pds.put("cntpg", pdsRepository.findAll(paging).getTotalPages());

        return pds;
    }
}
