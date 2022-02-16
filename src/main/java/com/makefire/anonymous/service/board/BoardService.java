package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> selectBoards() {
        return boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }


}
