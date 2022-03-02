package com.makefire.anonymous.domain.user.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *packageName : com.makefire.anonymous
 * fileName : Authority
 * author : 최푸름
 * date : 22-01-14
 * description : 권한 엔티티
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@Entity
public class Authority {
    @Id
    @GeneratedValue
    long id;

    @NotNull
    String admin;
}
