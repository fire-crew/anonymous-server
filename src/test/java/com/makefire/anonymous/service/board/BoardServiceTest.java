package com.makefire.anonymous.service.board;

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
    }

    @Test
    @DisplayName("selectBoardTest")
    void selectBoardTest() {
    }

    @Test
    @DisplayName("deleteBoardTest")
    void deleteBoardTest() {
    }

    @Test
    @DisplayName("selectBoardListTest")
    void selectBoardListTest() {
    }
}
