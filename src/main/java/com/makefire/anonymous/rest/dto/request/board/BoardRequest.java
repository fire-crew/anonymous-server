package com.makefire.anonymous.rest.dto.request.board;


import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

    @NotNull
    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    @NotNull
    private String author; /* 글 작성자 */

    @Builder
    public BoardRequest (String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public static Board to(BoardRequest boardRequest) {
        return Board.toWriteBuilder()
                .title(boardRequest.getTitle())
                .contents(boardRequest.getContents())
                .author(boardRequest.getAuthor())
                .build();
    }

}
