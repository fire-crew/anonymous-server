package com.makefire.anonymous.domain.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Board {

    @Id
    @GeneratedValue
    private long id;

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */

    private String create_date; /* 최초 작성일 */

    private String modified_date; /* 마지막 수정일 */
}
