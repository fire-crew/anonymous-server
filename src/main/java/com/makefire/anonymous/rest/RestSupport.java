package com.makefire.anonymous.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.makefire.anonymous.rest.dto.response.Response;
import java.nio.charset.StandardCharsets;

/**
 * @title 컨트롤러 공통 API 형식 추상 클래스
 * @version 1.0
 * @author choipureum
 * @date 22.02.27
 */
public abstract class RestSupport{
    final MediaType MEDIA_TYPE_APPLICATION_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    final String MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    protected<T> ResponseEntity<Response> response(T data){
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(200, data, "Ok"));
    }

    protected<T> ResponseEntity<Response> response_404(T data){
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(404, null, "ERROR"));
    }

    protected<T> ResponseEntity<Response> response_500(T data){
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(400, null, "ERROR"));
    }
}
