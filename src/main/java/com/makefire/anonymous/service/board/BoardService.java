package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.rest.dto.request.board.BoardSaveRequestDTO;
import com.makefire.anonymous.rest.dto.response.board.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;






    public List<BoardResponseDTO> findAll() {
        return boardRepository.findAll().stream().map(BoardResponseDTO::new).collect(Collectors.toList());
    }

    public BoardResponseDTO findById(Long id) {
        Board entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        return new BoardResponseDTO(entity);
    }

    public Long save(BoardSaveRequestDTO requestDTO) {
        return boardRepository.save(requestDTO.toEntity())
                .getId();
    }


}
