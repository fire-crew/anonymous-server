package com.makefire.anonymous.config.web.advice;

import com.makefire.anonymous.exception.BadRequestException;
import com.makefire.anonymous.exception.DuplicateException;
import com.makefire.anonymous.exception.ModelNotFoundException;
import com.makefire.anonymous.rest.core.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class, IllegalArgumentException.class,
            IndexOutOfBoundsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<?> handleBadRequest(Exception e) {
        log.info("BadRequest Exception, message: {{}}", e.getMessage());
        return ApiResult.ERROR(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResult<?> unAuthorized(Exception e, HttpServletResponse response) {
        log.info("AuthenticationException Exception, message: {{}}", e.getMessage());
        return ApiResult.ERROR(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResult<?> gone(Exception e) {
        log.info("AccessDeniedException Exception, message: {{}}", e.getMessage());
        return ApiResult.ERROR(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {ModelNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult<?> handleNotFound(Exception e) {
        log.info("ModelNotFoundException Exception, message: {{}}", e.getMessage());
        return ApiResult.ERROR(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> handleInternalServerError(Exception e) {
        log.info("Exception, message: {{}}", e.getMessage());
        e.printStackTrace();
        return ApiResult.ERROR(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DuplicateException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResult<?> handleConflict(Exception e) {
        log.info("Conflict Exception, message: {{}}", e.getMessage());
        return ApiResult.ERROR(e, HttpStatus.CONFLICT);
    }
}