package com.makefire.anonymous.service.board;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.exception.DuplicateException;
import com.makefire.anonymous.exception.ModelNotFoundException;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
//    private final ObjectMapper defaultObjectMapper = new ObjectMapper();
//    private volatile ObjectMapper objectMapper = null;

//    public ObjectMapper mapper() {
//        return objectMapper == null ? defaultObjectMapper : objectMapper;
//    }
//
//    public ObjectWriter writer() {
//        return mapper().writer().withDefaultPrettyPrinter();
//    }
//
//    public <T> String toJsonString(T model) {
//        ObjectWriter ow = writer().withDefaultPrettyPrinter();
//        try {
//            return ow.writeValueAsString(model);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    public BoardResponse insertBoard(BoardRequest boardRequest) {
        if (boardRequest.getId() != null) {
            boardRepository.findById(boardRequest.getId()).ifPresent(board -> {
                throw new DuplicateException(DuplicateException.BOARD_CONFLICT);
            });
        }
        Board board = BoardRequest.to(boardRequest);
        return BoardResponse.from(boardRepository.save(board));
    }

    public BoardResponse updateBoard(BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardRequest.getId()).orElseThrow(()
                -> new ModelNotFoundException(ModelNotFoundException.BOARD_NOT_FOUND));
        board.update(boardRequest);
        return BoardResponse.from(board);
    }

    public BoardResponse selectBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new ModelNotFoundException(ModelNotFoundException.BOARD_NOT_FOUND));
        return BoardResponse.from(board);
    }

    public Boolean deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new ModelNotFoundException(ModelNotFoundException.BOARD_NOT_FOUND));
        boardRepository.delete(board);
        return true;
    }

    public List<BoardResponse> selectBoardlist() {
        // TODO 페이징 처리 필요
        List<Board> boardList = boardRepository.findAll();
        return BoardResponse.fromList(boardList);
    }
}
