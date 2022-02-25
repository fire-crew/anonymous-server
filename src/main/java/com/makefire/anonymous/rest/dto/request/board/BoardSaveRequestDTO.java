package com.makefire.anonymous.rest.dto.request.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDTO {
    private String title;
    private String content;
    private String author;
    private Long authorId;

    @Builder
    public BoardSaveRequestDTO(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .authorId(authorId)
                .build();
    }

}
