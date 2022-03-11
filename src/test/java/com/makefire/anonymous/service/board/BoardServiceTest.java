package com.makefire.anonymous.service.board;

import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

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
public class BoardServiceTest extends SpringTestSupport {

    @Autowired
    private BoardService boardService;

    private BoardRequest boardRequest;

    @BeforeEach
    void setUp() {
        boardRequest = BoardFixture.createBoardRequestData();
    }

    @AfterEach
    void setDown() {
    }

//    @Test
//    @DisplayName("1번 게시물을 조회한다.")
//    void selectBoardTest() {
//        boardService.insertBoard(boardRequest);
//        BoardResponse board = boardService.selectBoard(1L);
//
//        Assertions.assertAll(
//                () -> assertEquals(boardRequest.getTitle(), board.getTitle()),
//                () -> assertEquals(boardRequest.getContents(), board.getContents()),
//                () -> assertEquals(boardRequest.getAuthor(), board.getAuthor())
//        );
//    }
//    @Test
//    @DisplayName("게시판 서비스 수정 테스트")
//    void updateBoardTest() {
//        BoardRequest boardRequest = BoardFixture.createUpdateBoardRequestData();
//        boardService.updateBoard(boardRequest);
//    }
}
