package com.makefire.anonymous.rest.dto.response.board;

import com.makefire.anonymous.domain.board.entity.Board;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {

    private long id; /* 글 ID */

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */

    private LocalDateTime createDate; /* 최초 작성일 */

    private LocalDateTime modifiedDate; /* 마지막 수정일 */

    @Builder
    public BoardResponse(Long id, String title, String contents, String author, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static BoardResponse from(Board board) {

        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .contents(board.getContents())
                .createDate(board.getCreatedDate())
                .modifiedDate(board.getLastModifiedDate())
                .build();
    }

    public static List<BoardResponse> fromList(List<Board> boards) {
        List<BoardResponse> boardList = new ArrayList<>();

        boards.forEach(board -> boardList.add(
                BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .contents(board.getContents())
                        .createDate(board.getCreatedDate())
                        .modifiedDate(board.getLastModifiedDate())
                        .build()
        ));

        return boardList;
    }
}
