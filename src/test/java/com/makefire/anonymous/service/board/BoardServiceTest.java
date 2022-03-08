package com.makefire.anonymous.service.board;

import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    private BoardRequest boardRequest;

    @BeforeEach
    void setUp() {
        boardRequest = BoardRequest.builder()
                .title("Test title")
                .contents("Test contents")
                .author("Test author")
                .build();
    }

    @Test
    @DisplayName("BoardService insertBoard 메소드 테스트")
    void insertBoardTest() {
        // when 
        BoardResponse savedBoard = boardService.insertBoard(boardRequest);

        // then
        assertEquals("Test title", savedBoard.getTitle());
        assertEquals("Test contents", savedBoard.getContents());
        assertEquals("Test author", savedBoard.getAuthor());
    }
}
