package com.makefire.anonymous.exception;

public class ModelNotFoundException extends RuntimeException {
    public static final String BOARD_NOT_FOUND = "해당하는 게시글을 찾을 수 없습니다.";

    public ModelNotFoundException() {
        super();
    }

    public ModelNotFoundException(String message) {
        super(message);
    }
}
