package com.makefire.anonymous.rest.controller.api.board;

import com.makefire.anonymous.rest.dto.request.board.RequestBoard;
import com.makefire.anonymous.rest.dto.response.board.ResponseBoard;
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
    public ResponseEntity<ResponseBoard> insertBoard(@Valid @RequestBody RequestBoard requestBoard) {
        return ResponseEntity.ok(boardService.insertBoard(requestBoard));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBoard> selectBoard(@PathVariable("id") Long boardId) {
        return ResponseEntity.ok(boardService.selectBoard(boardId));
    }
}
