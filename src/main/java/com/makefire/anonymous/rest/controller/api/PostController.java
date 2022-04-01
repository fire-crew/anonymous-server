package com.makefire.anonymous.rest.controller.api;


import com.makefire.anonymous.rest.RestSupport;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.Response;
import com.makefire.anonymous.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController extends RestSupport {

    private final PostService postService;


    @PostMapping
    public ResponseEntity<Response> createBoard(
            @Valid @RequestBody PostRequest postRequest) {
        log.info("createBoard", postRequest.toString());
        return response(postService.createBoard(postRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> selectBoard(@PathVariable("id") Long id) {

        return response(postService.selectBoard(id));

    }

    @GetMapping("/list")
    public ResponseEntity<Response> selectBoards() {
        return response(postService.selectBoards());
    }

    @PutMapping
    public ResponseEntity<Response> updateBoard(@Valid @RequestBody PostRequest postRequest) {
        return response(postService.updateBoard(postRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("id") Long id) {
        return response(postService.deleteBoard(id));
    }

}

