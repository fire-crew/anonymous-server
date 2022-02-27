package com.makefire.anonymous.rest.controller.api.board;

import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.board.BoardResponse;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
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
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardResponse> insertBoard(@Valid @RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok(boardService.insertBoard(boardRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> updateBoard(@PathVariable("id") Long boardId,
                                                     @Valid @RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok(boardService.updateBoard(boardId, boardRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> selectBoard(@PathVariable("id") Long boardId) {
        return ResponseEntity.ok(boardService.selectBoard(boardId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardResponse> deleteBoard(@PathVariable("id") Long boardId) {
        return ResponseEntity.ok(boardService.deleteBoard(boardId));
    }
}
