package com.makefire.anonymous.controller.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.controller.api.board.BoardController;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
@ExtendWith(SpringExtension.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    private MockMvc mvc;

    @MockBean
    private BoardService boardService;

    @BeforeEach
    public void setUp() {
        mvc =
                MockMvcBuilders.standaloneSetup(new BoardController(boardService))
                        .addFilters(new CharacterEncodingFilter("UTF-8", true))
                        .build();
    }

    @Test
    void insertBoardTest() throws Exception {
        // given
        given(boardService.insertBoard(any()))
                .willReturn(
                        BoardResponse.from(Board.builder()
                                .title("test Title")
                                .contents("test Contents")
                                .author("test Author")
                                .build())
                );

        // when
        final ResultActions actions =
                mvc.perform(
                        post("/board")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content("{"
                                        + " \"title\" : \"test Title\", "
                                        + " \"contents\" : \"test Contents\", "
                                        + " \"author\": \"test Author\" "
                                        + "}"));

        // then
        actions
                .andExpect(status().isOk()) // FIXME HttpStatusCode 200? 201?
                .andExpect(jsonPath("data.title").value("test Title"))
                .andExpect(jsonPath("data.contents").value("test Contents"))
                .andExpect(jsonPath("data.author").value("test Author"));
    }
}
