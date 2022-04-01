package com.makefire.anonymous.support.fixture;


import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import com.makefire.anonymous.rest.dto.response.post.PostResponse;
import java.util.Arrays;
import java.util.List;

public class BoardFixture {

    public static PostRequest createBoardRequest(){
        return PostRequest.builder()
                .id(1L)
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }

    public static PostResponse createBoardResponse(){
        return PostResponse.builder()
                .id(1L)
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }


    public static List<Post> createBoards(){
        Post post1 = Post.builder()
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();

        Post post2 = Post.builder()
                .title("testTitle2")
                .content("testContent2")
                .author("testAuthor2")
                .authorId(13L)
                .build();

        Post post3 = Post.builder()
                .title("testTitle3")
                .content("testContent3")
                .author("testAuthor3")
                .authorId(13L)
                .build();

        return Arrays.asList(post1, post2, post3);
    }

    public static Post createBoard(){
      return  Post.builder()
                .title("testTitle")
                .content("testContent")
                .author("testAuthor")
                .authorId(12L)
                .build();
    }

    public static PostRequest createUpdateBoard(){
        return  PostRequest.builder()
                .id(1L)
                .title("updateTitle")
                .content("updateContent")
                .author("updateAuthor")
                .authorId(12L)
                .build();
    }
}
