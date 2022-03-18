package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.support.ServiceTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * packageName : com.makefire.anonymous.service.board
 * fileName : BoardServiceTeest
 * author : kjho94
 * date : 2022-03-04
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-04  kjho94    최초 생성
 * ---------------------------------
 */
public class BoardServiceTest extends ServiceTestSupport {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("insertBoardTest")
    void insertBoardTest() {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();
        when(boardRepository.save(any())).thenReturn(BoardRequest.to(boardRequest));

        BoardResponse boardResponse = boardService.insertBoard(boardRequest);

        Assertions.assertAll(
                () -> assertEquals(boardRequest.getTitle(), boardResponse.getTitle())
        );
    }

    @Test
    @DisplayName("updateBoardTest")
    void updateBoardTest() {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();
        BoardRequest boardRequest1 = BoardFixture.createOneUpdateBoardRequest();
        when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));

        BoardResponse boardResponse = boardService.updateBoard(boardRequest1);

        Assertions.assertAll(
                () -> assertEquals(boardRequest1.getTitle(), boardResponse.getTitle())
        );
    }

    @Test
    @DisplayName("selectBoardTest")
    void selectBoardTest() {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();
        when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));

        BoardResponse boardResponse = boardService.selectBoard(1L);

        Assertions.assertAll(
                () -> assertEquals(boardRequest.getTitle(), boardResponse.getTitle())
        );
    }

    @Test
    @DisplayName("deleteBoardTest")
    void deleteBoardTest() {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();
        when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));

        Boolean result = boardService.deleteBoard(1L);

        Assertions.assertAll(
                () -> assertEquals(true, result)
        );
    }

    @Test
    @DisplayName("selectBoardListTest")
    void selectBoardListTest() {
        List<Board> boardList = BoardFixture.createSeveralBoard();
        when(boardRepository.findAll()).thenReturn(boardList);

        List<BoardResponse> boardResponseList = boardService.selectBoardList();

        Assertions.assertAll(
                () -> assertEquals(boardList.size(), boardResponseList.size())
        );
    }
}
