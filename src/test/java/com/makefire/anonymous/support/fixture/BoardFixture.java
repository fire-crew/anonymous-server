package com.makefire.anonymous.support.fixture;


import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;

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

}
