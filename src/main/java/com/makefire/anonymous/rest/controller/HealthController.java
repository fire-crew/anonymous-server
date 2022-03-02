package com.makefire.anonymous.rest.controller;

import com.makefire.anonymous.rest.RestSupport;
import com.makefire.anonymous.rest.dto.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *packageName : com.makefire.anonymous
 * fileName : HealthController
 * author : 최푸름
 * date : 22-01-14
 * description : 서버체킹 E2E
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@RestController
public class HealthController extends RestSupport {

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/v1/healthCheck")
    public ResponseEntity<Response> health(){
        return response("serverChecking...");
    }
}
