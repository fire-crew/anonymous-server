package com.makefire.anonymous.domain.board.entity;

import com.makefire.anonymous.domain.common.BaseEntity;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Entity;
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

    @NotNull
    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    @NotNull
    private String author; /* 글 작성자 */

    @Builder(builderMethodName = "toWriteBuilder")
    public Board (String title, String contents, String author) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(contents, "contents must not be null");
        Assert.notNull(author, "author must not be null");

        this.title = title;
        this.contents = contents;
        this.author = author;
    }

}
