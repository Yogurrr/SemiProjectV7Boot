package yogurrr.springboot.semiprojectv7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import yogurrr.springboot.semiprojectv7.model.Board;
import yogurrr.springboot.semiprojectv7.repository.BoardRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public Map<String, Object> selectBoard(int cpage) {
        // 페이징 시 저열 순서 지정
        Pageable paging = PageRequest.of(cpage, 25, Sort.by("bno").descending());
        // PageRequest.of(cpage, 25, Sort.Direction.DESC, "bno");

        List<Board> bdlist = boardRepository.findAll(paging).getContent();
        int cntpg = boardRepository.findAll(paging).getTotalPages();

        Map<String, Object> bds = new HashMap<>();
        bds.put("bdlist", bdlist);
        bds.put("cntpg", cntpg);

        return bds;
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {

        // like 검색에 대한 query method
        // findByTitleLike              : %검색어% (% 문자 제공 필요)
        // findByTitleConatins          : %검색어% (% 문자 제공 필요 X)
        // findByTitleStartsWith        : %검색어% (% 문자 제공 필요 X)
        // findByTitleEndsWith          : %검색어% (% 문자 제공 필요 X)

        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();
        int cpage = (int) params.get("stbno");

        Pageable paging = PageRequest.of(cpage, 25, Sort.Direction.DESC, "bno");

        List<Board> result = null;

        switch (ftype) {
            case "title" : // 제목으로 검색
                result = boardRepository.findByTitleContains(paging, fkey); break;

            case "titcont" : // 제목 + 본문으로 검색
                result = boardRepository.findByTitleContainsOrContentsContains(paging, fkey, fkey); break;

            case "userid" : // 작성자로 검색
                result = boardRepository.findByUserid(paging, fkey); break;

            case "contents" : // 본문으로 검색
                result = boardRepository.findByContentsContains(paging, fkey);
        }

        return result;
    }

    @Override
    public int countBoard(Map<String, Object> params) {

        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();

        int cnt = 0;
        switch (ftype) {
            case "title" : // 제목으로 검색
                cnt = boardRepository.countByTitleContains(fkey); break;

            case "titcont" : // 제목 + 본문으로 검색
                cnt = boardRepository.countByTitleContainsOrContentsContains(fkey, fkey); break;

            case "userid" : // 작성자로 검색
                cnt = boardRepository.countByUserid(fkey); break;

            case "contents" : // 본문으로 검색
                cnt = boardRepository.countByContentsContains(fkey);
        }

        return (int) Math.ceil(cnt / 25);
    }

    @Override
    public int insertBoard(Board bd) {
        return Math.toIntExact(boardRepository.save(bd).getBno());
    }

    @Override
    public Board selectOneBoard(int bno) {
        boardRepository.countViewBorad((long) bno);
        return boardRepository.findById((long) bno).get();
    }
}
