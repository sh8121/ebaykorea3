package examples.boot.springboard.service;

import examples.boot.springboard.domain.Board;
import examples.boot.springboard.domain.BoardContent;
import examples.boot.springboard.domain.Member;
import examples.boot.springboard.repository.BoardRepository;
import examples.boot.springboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Board addBoard(
            Long userId, String title, String content){
        Member member = memberRepository.getOne(userId);
        Board board = new Board();
        board.setMember(member);
        BoardContent boardContent = new BoardContent();
        boardContent.setContent(content);
        board.setBoardContent(boardContent);
        board.setCreateDate(LocalDateTime.now());
        board = boardRepository.save(board);
        return board;
    }

    @Transactional
    public Board getBoard(Long id){
        Board board = boardRepository.getOne(id);
        board.setReadCount(board.getReadCount() + 1);
        return board;
    }

    @Transactional(readOnly = true)
    public Page<Board> getBoards(int page){
        Pageable pageable = PageRequest.of(page - 1, 3);
        Page<Board> boards = boardRepository.getBoards(pageable);
        return boards;
    }
}
