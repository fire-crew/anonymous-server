package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>  {

//    @Query(value = "select boardName,postingTime from sample_board where boardName = :name", nativeQuery=true)
//    List<Board> searchParamRepo(@Param("boardName") String boardName);

    Board save(Board board);
    Optional<Board> findById(Long id);
    Optional<Board> findByBoardName(String boardName);
    List<Board> findAll();


}
