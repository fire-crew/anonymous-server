package com.makefire.anonymous.support.fixture;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * packageName : com.makefire.anonymous.support.fixture.board
 * fileName : BoardRequestFixture
 * author : kjho94
 * date : 2022-03-11
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-11  kjho94    최초 생성
 * ---------------------------------
 */
public class BoardFixture {

    public static Board createOneBoard() {
        return Board.builder()
                .title("Test title One")
                .contents("Test contents One")
                .author("Test author One")
                .build();
    }

    public static List<Board> createSeveralBoard() {

        Board board1 = Board.builder()
                .title("Test title 1")
                .contents("Test contents 1")
                .author("Test author 1")
                .build();

        Board board2 = Board.builder()
                .title("Test title 2")
                .contents("Test contents 2")
                .author("Test author 2")
                .build();

        Board board3 = Board.builder()
                .title("Test title 3")
                .contents("Test contents 3")
                .author("Test author 3")
                .build();

        return asList(board1, board2, board3);
    }

    public static BoardRequest createOneBoardRequest() {
        return BoardRequest.builder()
                .title("Test title One")
                .contents("Test contents One")
                .author("Test author One")
                .build();
    }

    public static BoardResponse createOneBoardResponse() {
        return BoardResponse.builder()
                .id(1L)
                .title("Test title One")
                .contents("Test contents One")
                .author("Test author One")
                .build();
    }

    public static BoardRequest createOneUpdateBoardRequest() {
        return BoardRequest.builder()
                .id(1L)
                .title("Test Update title One")
                .contents("Test Update contents One")
                .author("Test Update author One")
                .build();
    }

    public static BoardResponse createOneUpdateBoardResponse() {
        return BoardResponse.builder()
                .id(1L)
                .title("Test Update title One")
                .contents("Test Update contents One")
                .author("Test Update author One")
                .build();
    }
}