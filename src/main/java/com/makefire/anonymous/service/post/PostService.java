package com.makefire.anonymous.service.post;

import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.domain.post.repository.PostRepository;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.post.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse selectBoard(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return PostResponse.from(post);
    }

    public List<PostResponse> selectBoards() {
        List<Post> postList = postRepository.findAll();
        return PostResponse.fromList(postList);
    }

    @Transactional
    public PostResponse createBoard(PostRequest postRequest) {
        Post post = PostRequest.toEntity(postRequest);
        return PostResponse.from(postRepository.save(post));
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public PostResponse updateBoard(PostRequest postRequest) {
        Post post = postRepository.findById(postRequest.getId()).orElseThrow(() -> new IllegalArgumentException());
        post.update(postRequest);
        return PostResponse.from(post);
    }

    public Boolean deleteBoard(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        postRepository.delete(post);
        return true;
    }
}
