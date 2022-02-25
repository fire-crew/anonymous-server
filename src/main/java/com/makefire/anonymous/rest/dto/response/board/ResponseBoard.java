package com.makefire.anonymous.rest.dto.response.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.*;

@NoArgsConstructor( access = AccessLevel.PRIVATE)
@AllArgsConstructor( access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ResponseBoard {

    private long id; /* 글 ID */

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */

    private String createDate; /* 최초 작성일 */

    private String modifiedDate; /* 마지막 수정일 */

    public static ResponseBoard from(Board board) {
        if(board == null) return null;

        return ResponseBoard.builder()
                .id(board.getId())
                .title(board.getTitle())
                .contents(board.getContents())
                .createDate(board.getCreate_date())
                .modifiedDate(board.getModified_date())
                .build();
    }

}
