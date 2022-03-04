package com.makefire.anonymous.rest.controller.api;


import com.makefire.anonymous.rest.RestSupport;
import com.makefire.anonymous.rest.dto.request.board.BoardRequest;
import com.makefire.anonymous.rest.dto.response.Response;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController extends RestSupport {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<Response> createBoard(
            @Valid @RequestBody BoardRequest boardRequest) {
        log.info("createBoard", boardRequest.toString());
        return response(boardService.createBoard(boardRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> selectBoard(@PathVariable("id") Long id) {

        return response(boardService.selectBoard(id));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("id") Long id) {
        return response(boardService.deleteBoard(id));
    }

}

