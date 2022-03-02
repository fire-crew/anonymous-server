package com.makefire.anonymous.rest.controller.api.board;

import com.makefire.anonymous.rest.RestSupport;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.Response;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * packageName : com.makefire.anonymous
 * fileName : BoardController
 * author : 강정호
 * date : 22-02-22
 * description :
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-02-22 강정호
 * ---------------------------------
 */
@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
@Slf4j
public class BoardController extends RestSupport {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Response> insertBoard(
            @Valid @RequestBody BoardRequest boardRequest) {
        log.info("Insert Board Start: boardRequest -> {}", boardRequest.toString());
        return response(boardService.insertBoard(boardRequest));
    }

    @PutMapping
    public ResponseEntity<Response> updateBoard(
            @Valid @RequestBody BoardRequest boardRequest) {
        log.info("Update Board Start: boardRequest -> {}", boardRequest.toString());
        return response(boardService.updateBoard(boardRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> selectBoard(
            @PathVariable("id") Long boardId) {
        log.info("Select Board Start: boardId -> {}", boardId.toString());
        return response(boardService.selectBoard(boardId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteBoard(
            @PathVariable("id") Long boardId) {
        log.info("Delete Board Start: boardId -> {}", boardId.toString());
        return response(boardService.deleteBoard(boardId));
    }

    @GetMapping("/lists")
    public ResponseEntity<?> selectBoardList() {
        log.info("Select Board List Start");
        return response(boardService.selectBoardlist());
    }
}
