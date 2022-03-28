package com.makefire.anonymous.rest.dto.request.board;


import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

    private Long id; /* 전역 Sequence */

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */

    @Builder
    public BoardRequest(Long id, String title, String contents, String author) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public static Board to(BoardRequest boardRequest) {
        return Board.builder()
                .title(boardRequest.getTitle())
                .contents(boardRequest.getContents())
                .author(boardRequest.getAuthor())
                .build();
    }
}
