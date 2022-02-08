package com.makefire.anonymous;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnonymousApplicationTests {

    @Test
    void contextLoads() {
    }



    private final BoardRepository boardRepository;

    // 의존성 주입
    @Autowired
    public AnonymousApplicationTests(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Test
    void findBoard() {
        // 멤버 저장
        Board board = new Board();
        board.setBoardName("testBoard");
        boardRepository.save(board);

        // 저장한 멤버 아이디로 검색
        Board findBoard = boardRepository.findById(board.getId()).get();
        Assertions.assertThat(board.getBoardName()).isEqualTo(findBoard.getBoardName());
    }
}
