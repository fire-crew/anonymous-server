package com.makefire.anonymous.domain.post.repository;

import com.makefire.anonymous.domain.post.entity.Post;
import com.makefire.anonymous.support.SpringTestSupport;
import com.makefire.anonymous.support.fixture.PostFixture;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostRepositoryTest extends SpringTestSupport {
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        List<Post> postData = PostFixture.createPosts();
        postRepository.saveAll(postData);
    }

    @Test
    @DisplayName("findById 테스트")
    void getPostTest() {
        Post post = postRepository.findById(1L).get();

        Assertions.assertAll(
                () -> assertEquals(post.getId(), 1L)
        );
    }

    @Test
    @DisplayName("findAll 테스트")
    void getListOfPostTest() {
        List<Post> posts = postRepository.findAll();

        Assertions.assertAll(
                () -> assertEquals(posts.size(), 3)
        );
    }

    @Test
    @DisplayName("deleteAll 테스트")
    void deletePostTest() {
        postRepository.deleteAll();
        List<Post> posts = postRepository.findAll();
    /**
     * assertThat이 unitTest 에서
     * 가독성이나 유연성등의 측면에서 더 좋다는
     * 자료를 봐서 일단 적용해봄
     * 어떤게 더 날지 판단 부탁
    */
        assertThat(posts, IsEmptyCollection.empty());
    }
}
