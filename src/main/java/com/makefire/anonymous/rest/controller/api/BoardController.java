package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.domain.board.repository.BoardRepository;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public List<Board> searchAllBoards() {
        return boardService.selectBoards();
    }

//    @GetMapping("find")
//    public String searchByBoardName(@RequestParam(value = "name") String boardName) {
//        return boardRepository.findByBoardName(boardName).toString();
//    }


    @PostMapping
    public Board saveBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }


    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }






//    @GetMapping("searchParamRepo")
//    public String searchParamRepoMember(@RequestParam(value = "name") String boardName) {
//        return boardRepository.searchParamRepo(boardName).toString();
//    }
}
