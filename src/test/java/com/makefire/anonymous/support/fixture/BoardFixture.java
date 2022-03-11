package com.makefire.anonymous.support.fixture;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;

import java.util.ArrayList;
import java.util.List;

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

    public static BoardRequest createBoardRequestData() {
        return BoardRequest.builder()
                .title("Test title")
                .contents("Test contents")
                .author("Test author")
                .build();
    }

    public static List<Board> createBoardData() {

        List<Board> boardList = new ArrayList<>();

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

        boardList.add(board1);
        boardList.add(board2);
        boardList.add(board3);

        return boardList;
    }
}
