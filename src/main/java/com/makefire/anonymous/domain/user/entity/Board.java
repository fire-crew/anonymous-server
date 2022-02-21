package com.makefire.anonymous.domain.user.entity;

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
@Entity
public class Board {
    @Id
    @GeneratedValue
    private long id;

}
