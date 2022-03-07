package com.makefire.anonymous.domain.board.entity;


import com.makefire.anonymous.domain.common.BasicEntity;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BasicEntity {


    @NotNull(message = "Title must not be null")
    private String title;


    private String content;

    @NotNull(message = "Author must not be null")
    private String author;

    private Long authorId;


    @Builder
    public Board(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public void update(BoardRequest boardRequest){
        this.id = boardRequest.getId();
        this.title = boardRequest.getTitle();
        this.content = boardRequest.getContent();
        this.author = boardRequest.getAuthor();
        this.authorId = boardRequest.getAuthorId();
    }

}