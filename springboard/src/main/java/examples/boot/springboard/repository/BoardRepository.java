package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Query("select b from Board b")
//    @Query("Select b from Board b inner join fetch b.member")
    @Query("select b from Board b inner join fetch b.member inner join fetch b.boardContent")
    public List<Board> getBoards();
}
