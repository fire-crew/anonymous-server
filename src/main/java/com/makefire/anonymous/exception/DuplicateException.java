package com.makefire.anonymous.exception;

/**
 * packageName : com.makefire.anonymous.exception
 * fileName : DuplicationException
 * author : kjho94
 * date : 2022-03-02
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-02  kjho94    최초 생성
 * ---------------------------------
 */
public class DuplicateException extends RuntimeException {
    public static final String BOARD_CONFLICT = "해당하는 게시글 번호가 이미 존재합니다.";

    public DuplicateException() {
        super();
    }

    public DuplicateException(String message) {
        super(message);
    }
}
