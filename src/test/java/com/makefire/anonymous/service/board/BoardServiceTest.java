package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardServiceTest extends SpringTestSupport {

    @Autowired
    BoardService boardService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    @DisplayName("멤버 생성")
    void createBoardTest() {
        BoardRequest boardRequest = BoardFixture.createBoardRequest();
    }

}
