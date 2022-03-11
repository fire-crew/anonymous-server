package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * packageName : com.makefire.anonymous.domain.board.repository
 * fileName : BoardRepositoryTest
 * author : kjho94
 * date : 2022-03-03
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-03  kjho94    최초 생성
 * ---------------------------------
 */
public class BoardRepositoryTest extends SpringTestSupport {

    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        List<Board> boardData = BoardFixture.createBoardData();
        boardRepository.saveAll(boardData);
    }

    @AfterEach
    void setDown() {
        boardRepository.deleteAll();
    }

    @Test
    @DisplayName("조건 없이 게시판 전체 글 목록을 가져온다.")
    void selectBoardsTest() {
        List<Board> board = boardRepository.findAll();

        Assertions.assertAll(
                () -> assertEquals(board.size(), 3),
                () -> assertEquals(board.get(0).getTitle(), "Test title 1"),
                () -> assertEquals(board.get(1).getContents(), "Test contents 2"),
                () -> assertEquals(board.get(2).getAuthor(), "Test author 3")
        );
    }
}