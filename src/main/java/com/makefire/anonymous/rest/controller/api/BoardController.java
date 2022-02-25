package com.makefire.anonymous.rest.controller.api;


import com.makefire.anonymous.rest.dto.request.board.BoardSaveRequestDTO;
import com.makefire.anonymous.rest.dto.response.board.BoardResponseDTO;
import com.makefire.anonymous.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;



    @GetMapping("/findAll")
    public ResponseEntity<List<BoardResponseDTO>> boardList()  {

        return ResponseEntity.ok().body( boardService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDTO requestDTO) {

        return ResponseEntity.ok().body(boardService.save(requestDTO));
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<BoardResponseDTO> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(boardService.findById(id));
    }

}




