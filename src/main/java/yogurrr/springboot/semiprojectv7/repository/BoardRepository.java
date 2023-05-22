package yogurrr.springboot.semiprojectv7.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import yogurrr.springboot.semiprojectv7.model.Board;

import javax.transaction.Transactional;
import java.util.List;

// public interface BoardRepository extends JpaRepository<Board, Long> {
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {

    // JpaRepository에서는 DML은 지원 X
    // 단, Modifying, Transactional 등을 추가하면 사용 가능
    @Modifying
    @Transactional
    @Query("update Board set views = views + 1 where bno = :bno")
    int countViewBorad(@Param("bno") long bno);

    // @Query("select ceil(count(bno)/25) from Board")
    int countBoardBy();

    List<Board> findByTitleContains(Pageable paging, String fkey);
    List<Board> findByTitleContainsOrContentsContains(Pageable paging, String fkey1, String fkey2);
    List<Board> findByUserid(Pageable paging, String fkey);
    List<Board> findByContentsContains(Pageable paging, String fkey);

    // @Query("select bno,title,userid,regdate,thumbs,views from board where :ftype = :fkey", nativeQuery = true)
    // List<Board> findBoardBy(Pageable paging, String ftype, String fkey);
}