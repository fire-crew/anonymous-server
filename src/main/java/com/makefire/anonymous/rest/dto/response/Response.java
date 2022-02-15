package com.makefire.anonymous.rest.dto.response;

import com.sun.istack.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

/**
 * packageName : com.makefire.anonymous.rest.dto.response
 * fileName : Response
 * author : User
 * date : 2022-01-15
 * description :
 * ===========================================================
 * DATE AUTHOR NOTE
 * -----------------------------------------------------------
 * 2022-01-15 User 최초 생성
 */

public class Response<T> extends HttpEntity<T>{

    private final HttpStatus status;

    public Response(HttpStatus status) {
        this(null, null, status);
    }

    public Response(@Nullable T body, HttpStatus status) {
        this(body, null, status);
    }

    public Response(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers);
        Assert.notNull(status, "HttpStatus must not be null");
        this.status = status;
    }

}
