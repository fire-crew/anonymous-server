package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardRepositoryTest extends SpringTestSupport {
    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        List<Board> boardData = BoardFixture.createBoards();
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
    /**
     * assertThat이 unitTest 에서
     * 가독성이나 유연성등의 측면에서 더 좋다는
     * 자료를 봐서 일단 적용해봄
     * 어떤게 더 날지 판단 부탁
    */
        assertThat(boards, IsEmptyCollection.empty());
    }
}
