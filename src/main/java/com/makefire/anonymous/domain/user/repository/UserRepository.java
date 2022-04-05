package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.makefire.anonymous
 * fileName : UserRepository
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 기본 레포지토리
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
}
