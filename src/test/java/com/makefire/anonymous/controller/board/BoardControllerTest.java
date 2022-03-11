package com.makefire.anonymous.controller.board;

import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class BoardControllerTest extends SpringMockMvcTestSupport {

    @MockBean
    private BoardService boardService;

    private BoardRequest boardRequest;

    @BeforeEach
    void setUp() {
        boardRequest = BoardFixture.createBoardRequestData();
        boardService.insertBoard(boardRequest);
    }

    @Test
    @DisplayName("게시글을 등록하고 그 값을 비교한다.")
    void insertBoardTest() throws Exception {
        given(boardService.insertBoard(any(BoardRequest.class)))
                .willReturn(BoardResponse.from(BoardRequest.to(boardRequest)));

        this.mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"
                                + " \"title\" : \"Test title\", "
                                + " \"contents\" : \"Test contents\", "
                                + " \"author\": \"Test author\" "
                                + "}"))

                .andExpect(status().isOk()) // FIXME -> HttpStatusCode 200? 201? What is Right?
                .andExpect(jsonPath("data.title").value(boardRequest.getTitle()))
                .andExpect(jsonPath("data.contents").value(boardRequest.getContents()))
                .andExpect(jsonPath("data.author").value(boardRequest.getAuthor()))
                .andDo(print());
    }
}
