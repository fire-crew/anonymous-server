package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.domain.board.entity.Board;
import com.makefire.anonymous.rest.dto.response.Message;
import com.makefire.anonymous.rest.dto.response.Response;
import com.makefire.anonymous.rest.dto.response.StatusEnum;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public List<Board> searchAllBoards() {
        return boardService.selectBoards();
    }


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
    public Response<Message> getBoard(@PathVariable Long id) {
        Board board = boardService.getBoard(id);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("성공 코드");
        message.setData(board);

        return new Response<>(message, headers, HttpStatus.OK);
    }

}




