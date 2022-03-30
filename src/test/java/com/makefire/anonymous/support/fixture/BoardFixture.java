package com.makefire.anonymous.support.fixture;


import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import java.util.Arrays;
import java.util.List;

public class BoardFixture {

    public static BoardRequest createBoardRequest(){
        return BoardRequest.builder()
                .id(1L)
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }

    public static BoardResponse createBoardResponse(){
        return BoardResponse.builder()
                .id(1L)
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }


    public static List<Board> createBoards(){
        Board board1=Board.builder()
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();

        Board board2=Board.builder()
                .title("testTitle2")
                .content("testContent2")
                .author("testAuthor2")
                .authorId(13L)
                .build();

        Board board3=Board.builder()
                .title("testTitle3")
                .content("testContent3")
                .author("testAuthor3")
                .authorId(13L)
                .build();

        return Arrays.asList(board1,board2,board3);
    }

    public static Board createBoard(){
      return  Board.builder()
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }
}
