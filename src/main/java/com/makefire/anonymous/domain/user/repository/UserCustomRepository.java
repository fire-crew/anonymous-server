package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.User;

import java.util.List;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserCustomRepository
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 커스텀 레포지토리
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
public interface UserCustomRepository {
    List<User> getUserList();
}
