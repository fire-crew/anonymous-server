package com.makefire.anonymous.controller.board;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class    BoardControllerTest extends SpringMockMvcTestSupport {

    @MockBean
    private BoardService boardService;

    @Test
    @DisplayName("게시판 생성 테스트")
    void createBoardTest() throws Exception{
        BoardRequest boardRequest= BoardFixture.createBoardRequest();
        when(boardService.createBoard(any())).thenReturn(BoardResponse.from(BoardRequest.toEntity(boardRequest)));

        mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(boardRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(boardRequest.getTitle()))
                .andExpect(jsonPath("data.content").value(boardRequest.getContent()))
                .andExpect(jsonPath("data.author").value(boardRequest.getAuthor()))
                .andExpect(jsonPath("data.authorId").value(boardRequest.getAuthorId()))
                .andDo(print());

        verify(boardService).createBoard(refEq(boardRequest));
    }

    @Test
    @DisplayName("게시판 전체조회 테스트")
    void selectBoardsTest() throws Exception {
        List<Board> list=BoardFixture.createBoards();
        when(boardService.selectBoards()).thenReturn(BoardResponse.fromList(list));

        mockMvc.perform(get("/board/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].title").value(list.get(0).getTitle()))
                .andDo(print());
    }

    @Test
    @DisplayName("게시판 단건 조회 테스트")
    void selectBoardTest() throws Exception{
        BoardResponse boardResponse=BoardFixture.createBoardResponse();
        when(boardService.selectBoard(boardResponse.getId())).thenReturn(boardResponse);

        mockMvc.perform(get("/board/"+boardResponse.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(boardResponse.getTitle()))
                .andExpect(jsonPath("data.content").value(boardResponse.getContent()))
                .andExpect(jsonPath("data.author").value(boardResponse.getAuthor()))
                .andExpect(jsonPath("data.authorId").value(boardResponse.getAuthorId()))
                .andDo(print());
    }

    @Test
    @DisplayName("게시판 업데이트 테스트")
    void updateBoardTest() {

    }



    @Test
    @DisplayName("게시판 삭제 ")
    void deleteBoardTest()throws Exception{
       when(boardService.deleteBoard(any())).thenReturn(true);

        mockMvc.perform(delete("/board/"+1L))
                .andExpect(status().isOk())
                .andDo(print());

        verify(boardService,times(1)).deleteBoard(eq(1L));
    }
}
