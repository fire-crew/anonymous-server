package com.makefire.anonymous.controller.post;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.post.PostResponse;
import com.makefire.anonymous.service.post.PostService;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.fixture.PostFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PostControllerTest extends SpringMockMvcTestSupport {

    @MockBean
    private PostService postService;

    @Test
    @DisplayName("게시판 생성 테스트")
    void createPostTest() throws Exception{
        PostRequest postRequest = PostFixture.createPostRequest();
        when(postService.createPost(any())).thenReturn(PostResponse.from(PostRequest.toEntity(postRequest)));

        mockMvc.perform(post("/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(postRequest.getTitle()))
                .andExpect(jsonPath("data.content").value(postRequest.getContent()))
                .andExpect(jsonPath("data.author").value(postRequest.getAuthor()))
                .andExpect(jsonPath("data.authorId").value(postRequest.getAuthorId()))
                .andDo(print());

        verify(postService).createPost(refEq(postRequest));
    }

    @Test
    @DisplayName("게시판 전체조회 테스트")
    void selectPostsTest() throws Exception {
        List<Post> list= PostFixture.createPosts();
        when(postService.selectPosts()).thenReturn(PostResponse.fromList(list));

        mockMvc.perform(get("/post/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].title").value(list.get(0).getTitle()))
                .andDo(print());
    }

    @Test
    @DisplayName("게시판 단건 조회 테스트")
    void selectPostTest() throws Exception{
        PostResponse postResponse = PostFixture.createPostResponse();
        when(postService.selectPost(postResponse.getId())).thenReturn(postResponse);

        mockMvc.perform(get("/post/"+ postResponse.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(postResponse.getTitle()))
                .andExpect(jsonPath("data.content").value(postResponse.getContent()))
                .andExpect(jsonPath("data.author").value(postResponse.getAuthor()))
                .andExpect(jsonPath("data.authorId").value(postResponse.getAuthorId()))
                .andDo(print());
    }

    @Test
    @DisplayName("게시판 업데이트 테스트")
    void updatePostTest() throws Exception {
        PostRequest postUpdateRequest=PostFixture.updatePostRequest();
        PostResponse updatePostResponse=PostFixture.updatePostResponse();
        when(postService.updatePost(any())).thenReturn(updatePostResponse);

        mockMvc.perform(put("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postUpdateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.title").value(postUpdateRequest.getTitle()))
                .andExpect(jsonPath("data.author").value(postUpdateRequest.getAuthor()))
                .andExpect(jsonPath("data.content").value(postUpdateRequest.getContent()))
                .andDo(print());

    }



    @Test
    @DisplayName("게시판 삭제 ")
    void deletePostTest()throws Exception{
       when(postService.deletePost(any())).thenReturn(true);

        mockMvc.perform(delete("/post/"+1L))
                .andExpect(status().isOk())
                .andDo(print());

        verify(postService,times(1)).deletePost(eq(1L));
    }
}
