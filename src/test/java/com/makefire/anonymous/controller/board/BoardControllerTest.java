package com.makefire.anonymous.controller.board;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BoardControllerTest extends SpringMockMvcTestSupport {

    @MockBean
    BoardService boardService;

    @Test
    @DisplayName("게시판 전체조회 테스트")
    void selectBoardsTest() throws Exception {
        List<BoardResponse> list = new ArrayList<>();
        list.add(BoardResponse.builder().title("testTitle").build());
        given(boardService.selectBoards()).willReturn(list);

        mockMvc.perform(get("/board/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].title", containsString("testTitle")))
                .andDo(print());
    }

    @Test
    @DisplayName("게시판 생성 테스트")
    void createBoardTest() throws Exception{
        BoardRequest boardRequest= BoardFixture.createBoardRequest();

        mockMvc.perform(post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(boardRequest)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(boardService).createBoard(refEq(boardRequest));
    }
}
