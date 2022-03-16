package com.makefire.anonymous.support.fixture;


import com.makefire.anonymous.rest.dto.request.board.BoardRequest;

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

}
