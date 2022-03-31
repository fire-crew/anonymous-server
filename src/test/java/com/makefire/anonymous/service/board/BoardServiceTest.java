package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class BoardServiceTest extends SpringTestSupport {

    @InjectMocks
    BoardService boardService;

    @Mock
    private BoardRepository boardRepository;

    @Nested
    class CreateCommonRequest{
        BoardRequest boardRequest=BoardFixture.createBoardRequest();

        @Test
        @DisplayName("Board를 생성하여 저장한다.")
        void createBoardTest() {
            when(boardRepository.save(any())).thenReturn(BoardRequest.toEntity(boardRequest));
            BoardResponse boardResponse=boardService.createBoard(boardRequest);
            assertEquals(boardRequest.getTitle(),boardResponse.getTitle());
        }

        @Test
        @DisplayName("Board를 생성하여 저장한다.")
        void updateBoardTest() {
            BoardRequest boardRequest1=BoardFixture.createUpdateBoard();
            when(boardRepository.findById(any())).thenReturn(Optional.of(BoardRequest.toEntity(boardRequest)));
            BoardResponse boardResponse=boardService.updateBoard(boardRequest1);
            assertEquals(boardRequest1.getTitle(),boardResponse.getTitle());
        }

    }


}
