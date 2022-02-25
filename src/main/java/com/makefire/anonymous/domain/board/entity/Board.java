package com.makefire.anonymous.domain.board.entity;


import com.makefire.anonymous.domain.common.BasicEntity;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="BOARD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BasicEntity {



    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;


    private String author;

    private Long authorId;


    @Builder
    public Board(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

}