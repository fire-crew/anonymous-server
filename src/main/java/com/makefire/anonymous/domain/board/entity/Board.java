package com.makefire.anonymous.domain.board.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.makefire.anonymous.domain.common.BaseEntity;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * packageName : com.makefire.anonymous
 * fileName : Board
 * author : 강정호
 * date : 22-02-22
 * description : 게시판 엔티티
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-02-22 강정호
 * ---------------------------------
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity{

    @NotNull(message = "board title must not be null")
    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    @NotNull(message = "board author must not be null")
    private String author; /* 글 작성자 */

    @Builder
    public Board (String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public void update(BoardRequest boardRequest) {
        this.id = boardRequest.getId();
        this.title  = boardRequest.getTitle();
        this.contents = boardRequest.getContents();
        this.author = boardRequest.getAuthor();
    }
}
