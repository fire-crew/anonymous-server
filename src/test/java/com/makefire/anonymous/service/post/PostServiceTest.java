package com.makefire.anonymous.service.post;

import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.domain.post.repository.PostRepository;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.post.PostResponse;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.PostFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class PostServiceTest extends SpringTestSupport {

    @InjectMocks
    PostService postService;

    @Mock
    private PostRepository postRepository;

    @Nested
    class CreateCommonRequest{
        PostRequest postRequest = PostFixture.createPostRequest();

        @Test
        @DisplayName("Post를 생성하여 저장한다.")
        void createPostTest() {
            when(postRepository.save(any())).thenReturn(PostRequest.toEntity(postRequest));
            PostResponse postResponse = postService.createPost(postRequest);
            assertEquals(postRequest.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("Post를 생성하여 저장한다.")
        void updatePostTest() {
            PostRequest postRequest1 = PostFixture.createUpdatePost();
            when(postRepository.findById(any())).thenReturn(Optional.of(PostRequest.toEntity(postRequest)));
            PostResponse postResponse = postService.updatePost(postRequest1);
            assertEquals(postRequest1.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("Post를 단건 조회한다")
        void getPostTest(){
            when(postRepository.findById(any())).thenReturn(Optional.ofNullable(PostRequest.toEntity(postRequest)));
            PostResponse postResponse = postService.selectPost(1L);
            assertEquals(postRequest.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("id 를 입력받아 데이터를 삭제한다.")
        void deletePostTest() {
            when(postRepository.findById(any())).thenReturn(Optional.of(PostRequest.toEntity(postRequest)));
            Boolean result = postService.deletePost(1L);
            assertEquals(true, result);
        }

    }

    @Test
    @DisplayName("모든 데이터를 찾아 반환한다.")
    void selectPostListTest() {
        List<Post> postList = PostFixture.createPosts();
        when(postRepository.findAll()).thenReturn(postList);
        List<PostResponse> postResponseList = postService.selectPosts();
        assertEquals(postList.size(), postResponseList.size());
    }


}
