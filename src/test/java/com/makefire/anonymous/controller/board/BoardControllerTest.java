package com.makefire.anonymous.controller.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import com.makefire.anonymous.support.ControllerTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * packageName : com.makefire.anonymous.controller.board
 * fileName : BoardControllerTest
 * author : kjho94
 * date : 2022-03-03
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-03  kjho94    최초 생성
 * ---------------------------------
 */
public class BoardControllerTest extends ControllerTestSupport {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("BoardRequest 데이터를 입력받아 이를 적재하고 200과 BoardResponse 데이터를 반환한다.")
    void insertBoardTest() throws Exception {
        BoardRequest boardRequest = BoardFixture.createOneBoardRequest();

        when(boardService.insertBoard(any())).thenReturn(BoardResponse.from(BoardRequest.to(boardRequest)));

        mockMvc.perform(post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(boardRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(boardRequest.getTitle()))
                .andExpect(jsonPath("data.author").value(boardRequest.getAuthor()))
                .andExpect(jsonPath("data.contents").value(boardRequest.getContents()))
                .andDo(print());
    }

    @Test
    @DisplayName("BoardRequest 데이터를 입력받아 이를 업데이트하고 200과 BoardResponse 데이터를 반환한다.")
    void updateBoardTest() throws Exception {
        BoardRequest boardUpdateRequest = BoardFixture.createOneUpdateBoardRequest();
        BoardResponse boardUpdateResponse = BoardFixture.createOneUpdateBoardResponse();

        when(boardService.updateBoard(any())).thenReturn(boardUpdateResponse);

        mockMvc.perform(put("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(boardUpdateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(boardUpdateRequest.getTitle()))
                .andExpect(jsonPath("data.author").value(boardUpdateRequest.getAuthor()))
                .andExpect(jsonPath("data.contents").value(boardUpdateRequest.getContents()))
                .andDo(print());
    }

    @Test
    @DisplayName("BoardId 데이터를 입력받아 200과 BoardId에 해당하는 BoardResponse 데이터를 반환한다.")
    void selectBoardTest() throws Exception {
        BoardResponse boardResponse = BoardFixture.createOneBoardResponse();

        when(boardService.selectBoard(any())).thenReturn(boardResponse);

        mockMvc.perform(get("/board/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(boardResponse.getTitle()))
                .andExpect(jsonPath("data.author").value(boardResponse.getAuthor()))
                .andExpect(jsonPath("data.contents").value(boardResponse.getContents()))
                .andDo(print());
    }

    @Test
    @DisplayName("BoardId 데이터를 입력받아 데이터를 삭제하고 200과 true를 반환한다.")
    void deleteBoardTest() throws Exception {
        when(boardService.deleteBoard(any())).thenReturn(true);

        mockMvc.perform(get("/board/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    // TODO selectBoardList Test
}
