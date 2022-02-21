package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.makefire.anonymous
 * fileName : BoardRepository
 * author : 강정호
 * date : 22-02-22
 * description : 게시판 기본 레포지토리
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-02-22 강정호
 * ---------------------------------
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
