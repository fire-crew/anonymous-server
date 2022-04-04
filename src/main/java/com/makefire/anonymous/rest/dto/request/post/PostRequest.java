package com.makefire.anonymous.rest.dto.request.post;

import com.makefire.anonymous.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequest {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long authorId;

    @Builder
    public PostRequest(Long id, String title, String content, String author, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public static Post toEntity(PostRequest postRequest) {
        return Post.builder()
                .title(postRequest.title)
                .content(postRequest.content)
                .author(postRequest.author)
                .authorId(postRequest.authorId)
                .build();

    }

}
