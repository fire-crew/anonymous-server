package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataBoardRepository extends JpaRepository<Board, String>, BoardRepository {

    @Override
    Optional<Board> findByBoardName(String boardName);
}
