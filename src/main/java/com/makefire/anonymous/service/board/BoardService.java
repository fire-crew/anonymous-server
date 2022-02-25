package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.exception.BadRequestException;
import com.makefire.anonymous.rest.dto.response.board.ResponseBoard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName : com.makefire.anonymous
 * fileName : BoardService
 * author : 강정호
 * date : 22-02-22
 * description : 게시판 비즈니스로직 인터페이스
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-02-22 강정호
 * ---------------------------------
 */
@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public ResponseBoard selectBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BadRequestException("Cannot found board"));

        return ResponseBoard.from(board);
    }

}
