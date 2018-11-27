package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Board;
import examples.boot.springboard.domain.Member;
import examples.boot.springboard.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void getBoards() throws Exception{
        // 1 + n
        // jpql : select b from Board b
        // jpql : select b from Board b inner join fetch b.member
        // jqpl : select b from Board b inner join fetch b.member inner join fetch b.boardContent
        List<Board> boards = boardRepository.getBoards();
        for(Board board : boards){
            System.out.println(board.getMember().getName());
            System.out.println(board.getTitle());
        }
    }
}
