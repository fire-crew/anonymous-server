package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserRepository
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 기본 레포지토리
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * 22-02-14 김민철
 * ---------------------------------
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
