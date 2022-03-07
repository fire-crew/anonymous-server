package com.makefire.anonymous.rest.dto.request.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequest {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long authorId;

    @Builder
    public BoardRequest(Long id,String title, String content, String author, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public static Board toEntity(BoardRequest boardRequest) {
        return Board.builder()
                .title(boardRequest.title)
                .content(boardRequest.content)
                .author(boardRequest.author)
                .authorId(boardRequest.authorId)
                .build();

    }

}
