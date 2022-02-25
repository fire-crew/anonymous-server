package com.makefire.anonymous.rest.dto.response.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardResponseDTO {

    private Long id, authorId;
    private String title, content, author;

    @Setter
    private Long viewCount;

    public BoardResponseDTO(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.authorId = entity.getAuthorId();
    }
}
