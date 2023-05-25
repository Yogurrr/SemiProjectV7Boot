package yogurrr.springboot.semiprojectv7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yogurrr.springboot.semiprojectv7.dao.PdsDAO;
import yogurrr.springboot.semiprojectv7.model.Pds;
import yogurrr.springboot.semiprojectv7.model.PdsAttach;
import yogurrr.springboot.semiprojectv7.utils.PdsUtils;

import java.util.HashMap;
import java.util.Map;

@Service("pdssrv")
public class PdsServiceImpl implements PdsService{

    @Autowired
    PdsDAO pdsdao;

    @Autowired
    PdsUtils pdsUtils;

    @Override
    public Map<String, Object> newPds(Pds pds) {
        pds.setUuid(pdsUtils.makeUUID());   // 식별코드 생성
        int pno = pdsdao.insertPds(pds);   // 폼 데이터를 DB에 저장

        // 첨부파일을 시스템에 저장할 때 사용할 정보를 Map에 저장
        Map<String, Object> pinfo = new HashMap<>();
        pinfo.put("pno", pno);
        pinfo.put("uuid", pds.getUuid());

        return pinfo;
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, Map<String, Object> pinfo) {

        // 첨부파일 업로드 처리
        PdsAttach pa = pdsUtils.processUpload(attach, pinfo);
        // 첨부파일 정보 디비에 저장
        int pano = pdsdao.insertPdsAttach(pa);

        return (pano > 0) ? true : false;
    }

    @Override
    public Map<String, Object> readPds(Integer cpg) {
        return pdsdao.selectPds(cpg - 1);
    }

    @Override
    public Pds readOnePds(int pno) {
        return pdsdao.selectOnePds(pno);
    }

    @Override
    public PdsAttach readPdsAttach(int pno) {
        return pdsdao.selectOnePdsAttach(pno);
    }
}
