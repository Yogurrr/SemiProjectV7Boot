package yogurrr.springboot.semiprojectv7.service;

import yogurrr.springboot.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    Map<String, Object> readBoard(int cpage);
    Map<String, Object> readBoard(int cpage, String ftype, String fkey);
//    int countBoard(String ftype, String fkey);
    boolean newBoard(Board bd);
    Board readOneBoard(int bno);
}