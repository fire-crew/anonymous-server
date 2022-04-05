package com.makefire.anonymous.domain.post.entity;


import com.makefire.anonymous.domain.common.BasicEntity;
import com.makefire.anonymous.rest.dto.request.post.PostRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BasicEntity {


    @NotNull(message = "Title must not be null")
    private String title;

    private String content;

    @NotNull(message = "Author must not be null")
    private String author;

    private Long authorId;

    @Builder
    public Post(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public void update(PostRequest postRequest){
        this.id = postRequest.getId();
        this.title = postRequest.getTitle();
        this.content = postRequest.getContent();
        this.author = postRequest.getAuthor();
        this.authorId = postRequest.getAuthorId();
    }

}