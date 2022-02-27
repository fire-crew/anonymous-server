package com.makefire.anonymous.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 *packageName : com.makefire.anonymous
 * fileName : User
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 엔티티
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * 22-02-08 김민철
 * ---------------------------------
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "SYS_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="USER_ID", nullable = false)
    private String userId; //아이디

    @Column(name="USER_NM", nullable = false)
    private String name; //이름

    @Column(name="PWD", nullable = false)
    private String password; //패스워드

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate; //등록일자

    @Builder
    public User(String userId, String name, String password){
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

}
