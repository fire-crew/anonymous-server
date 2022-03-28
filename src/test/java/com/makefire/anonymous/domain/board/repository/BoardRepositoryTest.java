package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.support.RepositoryTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
public class BoardRepositoryTest extends RepositoryTestSupport {

    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        List<Board> boardData = BoardFixture.createSeveralBoard();
        boardRepository.saveAll(boardData);
    }

    @Test
    @DisplayName("findById 테스트")
    void getBoardTest() {
        Board board = boardRepository.findById(1L).get();

        Assertions.assertAll(
                () -> assertEquals(board.getId(), 1L)
        );
    }

    @Test
    @DisplayName("findAll 테스트")
    void getListOfBoardTest() {
        List<Board> boards = boardRepository.findAll();

        Assertions.assertAll(
                () -> assertEquals(boards.size(), 3)
        );
    }

    @Test
    @DisplayName("deleteAll 테스트")
    void deleteBoardTest() {
        boardRepository.deleteAll();
        List<Board> boards = boardRepository.findAll();

        Assertions.assertAll(
                () -> assertEquals(boards.size(), 0)
        );
    }
}