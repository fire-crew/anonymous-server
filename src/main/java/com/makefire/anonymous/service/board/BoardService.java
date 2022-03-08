package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public BoardResponse selectBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return BoardResponse.from(board);
    }

    public List<BoardResponse> selectBoards() {
        List<Board> boardList = boardRepository.findAll();
        return BoardResponse.fromList(boardList);
    }

    @Transactional
    public BoardResponse createBoard(BoardRequest boardRequest) {
        Board board = BoardRequest.toEntity(boardRequest);
        return BoardResponse.from(boardRepository.save(board));
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public Boolean updateBoard(BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardRequest.getId()).orElseThrow(() -> new IllegalArgumentException());
        board.update(boardRequest);
        return true;
    }

    public Boolean deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        boardRepository.delete(board);
        return true;
    }
}
