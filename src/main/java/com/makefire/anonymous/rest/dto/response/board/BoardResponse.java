package com.makefire.anonymous.rest.dto.response.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor( access = AccessLevel.PROTECTED)
@Builder
public class BoardResponse {

    private long id; /* 글 ID */

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */

    private LocalDateTime createDate; /* 최초 작성일 */

    private LocalDateTime modifiedDate; /* 마지막 수정일 */

    public static BoardResponse from(Board board) {

        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .contents(board.getContents())
                .createDate(board.getCreatedDate())
                .modifiedDate(board.getLastModifiedDate())
                .build();
    }

}