package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.domain.board.repository.SpringDataBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class BoardController {

    private final BoardRepository boardRepository;
    private final SpringDataBoardRepository springDataBoardRepository;

    @GetMapping("search")
    public String searchAllBoard() {
        return boardRepository.findAll().toString();
    }

    @GetMapping("find")
    public String searchByBoardName(@RequestParam(value = "name") String boardName) {
        return boardRepository.findByBoardName(boardName).toString();
    }



//    @GetMapping("searchParamRepo")
//    public String searchParamRepoMember(@RequestParam(value = "name") String boardName) {
//        return boardRepository.searchParamRepo(boardName).toString();
//    }
}
