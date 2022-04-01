package com.makefire.anonymous.service.post;

import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.domain.post.repository.PostRepository;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.post.PostResponse;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.BoardFixture;
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
        PostRequest postRequest =BoardFixture.createBoardRequest();

        @Test
        @DisplayName("Board를 생성하여 저장한다.")
        void createBoardTest() {
            when(postRepository.save(any())).thenReturn(PostRequest.toEntity(postRequest));
            PostResponse postResponse = postService.createBoard(postRequest);
            assertEquals(postRequest.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("Board를 생성하여 저장한다.")
        void updateBoardTest() {
            PostRequest postRequest1 =BoardFixture.createUpdateBoard();
            when(postRepository.findById(any())).thenReturn(Optional.of(PostRequest.toEntity(postRequest)));
            PostResponse postResponse = postService.updateBoard(postRequest1);
            assertEquals(postRequest1.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("Board를 단건 조회한다")
        void getPostTest(){
            when(postRepository.findById(any())).thenReturn(Optional.ofNullable(PostRequest.toEntity(postRequest)));
            PostResponse postResponse = postService.selectBoard(1L);
            assertEquals(postRequest.getTitle(), postResponse.getTitle());
        }

        @Test
        @DisplayName("id 를 입력받아 데이터를 삭제한다.")
        void deleteBoardTest() {
            when(postRepository.findById(any())).thenReturn(Optional.of(PostRequest.toEntity(postRequest)));
            Boolean result = postService.deleteBoard(1L);
            assertEquals(true, result);
        }

    }

    @Test
    @DisplayName("모든 데이터를 찾아 반환한다.")
    void selectBoardListTest() {
        List<Post> postList = BoardFixture.createBoards();
        when(postRepository.findAll()).thenReturn(postList);
        List<PostResponse> postResponseList = postService.selectBoards();
        assertEquals(postList.size(), postResponseList.size());
    }


}
