package com.makefire.anonymous.rest.dto.response.post;

import com.makefire.anonymous.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponse {

    private Long id, authorId;
    private String title, content, author;
    private LocalDateTime createdDate, modifiedDate;


    @Builder
    public PostResponse(Long id, Long authorId, String title, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;

    }

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .authorId(post.getAuthorId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .createdDate(post.getCreatedDate())
                .modifiedDate(post.getModifiedDate())
                .build();
    }

    public static List<PostResponse> fromList(List<Post> postList) {
        List<PostResponse> postResponseList = new ArrayList<>();
        for (Post post : postList
        ) {
            postResponseList.add(PostResponse.builder()
                    .id(post.getId())
                    .authorId(post.getAuthorId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .author(post.getAuthor())
                    .createdDate(post.getCreatedDate())
                    .modifiedDate(post.getModifiedDate())
                    .build());
        }
        return postResponseList;
    }

}
