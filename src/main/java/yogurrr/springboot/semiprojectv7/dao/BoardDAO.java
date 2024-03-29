package yogurrr.springboot.semiprojectv7.dao;

import yogurrr.springboot.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    Map<String, Object> selectBoard(int cpage);
//    List<Board> selectBoard(Map<String, Object> params);
    Map<String, Object> selectBoard(Map<String, Object> params);

//    int countBoard(Map<String, Object> params);

    int insertBoard(Board bd);

    Board selectOneBoard(int bno);
}
