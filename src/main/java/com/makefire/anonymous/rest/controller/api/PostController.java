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
    public ResponseEntity<Response> createPost(
            @Valid @RequestBody PostRequest postRequest) {
        log.info("createPost", postRequest.toString());
        return response(postService.createPost(postRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> selectPost(@PathVariable("id") Long id) {
        return response(postService.selectPost(id));
    }

    @GetMapping("/list")
    public ResponseEntity<Response> selectPosts() {
        return response(postService.selectPosts());
    }

    @PutMapping
    public ResponseEntity<Response> updatePost(@Valid @RequestBody PostRequest postRequest) {
        return response(postService.updatePost(postRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePost(@PathVariable("id") Long id) {
        return response(postService.deletePost(id));
    }

}

