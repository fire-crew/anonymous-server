package com.makefire.anonymous.controller.board;


import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
}
