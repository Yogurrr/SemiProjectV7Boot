package yogurrr.springboot.semiprojectv7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yogurrr.springboot.semiprojectv7.model.Board;
import yogurrr.springboot.semiprojectv7.repository.BoardRepository;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("board save")
    public void saveBoard() {
        Board b = new Board(null, "테스트입니다", "aaa111", null, null, "테스트", null);

        boardRepository.save(b);
    }
}
