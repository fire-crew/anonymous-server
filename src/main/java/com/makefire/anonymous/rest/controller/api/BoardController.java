package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("search")
    public String searchAllBoard() {
        return boardRepository.findAll().toString();
    }
}
