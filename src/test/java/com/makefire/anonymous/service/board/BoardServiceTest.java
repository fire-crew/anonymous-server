package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.support.ServiceTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.*;
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

    @Nested
    class CreateBoardRequest {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();

        @Test
        @DisplayName("입력받은 boardRequest 데이터를 Repository 에 저장한다.")
        void insertBoardTest() {
            when(boardRepository.save(any())).thenReturn(BoardRequest.to(boardRequest));
            BoardResponse boardResponse = boardService.insertBoard(boardRequest);

            Assertions.assertAll(
                    () -> assertEquals(boardRequest.getTitle(), boardResponse.getTitle())
            );
        }

        @Test
        @DisplayName("Repository 에 저장되어 있는 기존 데이터를 입력받은 boardRequest 데이터로 업데이트한다.")
        void updateBoardTest() {
            BoardRequest boardRequest1 = BoardFixture.createOneUpdateBoardRequest();
            when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));
            BoardResponse boardResponse = boardService.updateBoard(boardRequest1);

            Assertions.assertAll(
                    () -> assertEquals(boardRequest1.getTitle(), boardResponse.getTitle())
            );
        }

        @Test
        @DisplayName("입력받은 id 로 Repository 에 저장되어 있는 데이터를 찾아 반환한다.")
        void selectBoardTest() {
            when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));
            BoardResponse boardResponse = boardService.selectBoard(1L);

            Assertions.assertAll(
                    () -> assertEquals(boardRequest.getTitle(), boardResponse.getTitle())
            );
        }

        @Test
        @DisplayName("입력받은 id 로 Repository 에 저장되어 있는 데이터를 삭제한다.")
        void deleteBoardTest() {
            when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.to(boardRequest)));
            Boolean result = boardService.deleteBoard(1L);

            Assertions.assertAll(
                    () -> assertEquals(true, result)
            );
        }
    }

    @Test
    @DisplayName("Repository 에 저장되어 있는 모든 데이터를 찾아 반환한다.")
    void selectBoardListTest() {
        List<Board> boardList = BoardFixture.createSeveralBoard();
        when(boardRepository.findAll()).thenReturn(boardList);

        List<BoardResponse> boardResponseList = boardService.selectBoardList();

        Assertions.assertAll(
                () -> assertEquals(boardList.size(), boardResponseList.size())
        );
    }
}
