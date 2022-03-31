package com.makefire.anonymous.domain.user.entity;

import com.makefire.anonymous.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 *packageName : com.makefire.anonymous
 * fileName : User
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 엔티티
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@Table(name="user")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private String name;

    @Builder
    public User (String name) {
        this.name = name;
    }
}
