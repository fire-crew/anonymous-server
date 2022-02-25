package com.makefire.anonymous.rest.dto.request.board;


import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class BoardRequest {

//    private Long id; /* 글 ID */

    private String title; /* 글 제목 */

    private String contents; /* 글 내용 */

    private String author; /* 글 작성자 */
}
