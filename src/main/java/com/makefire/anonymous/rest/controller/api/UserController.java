package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.rest.RestSupport;
import com.makefire.anonymous.rest.dto.request.UserRequest;
import com.makefire.anonymous.rest.dto.response.Response;
import com.makefire.anonymous.rest.dto.response.UserResponse;
import com.makefire.anonymous.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserController
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 E2E
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-02-16 김민철
 * ---------------------------------
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends RestSupport{

    private final UserService userService;

    @PostMapping("/userSignUp")
    public ResponseEntity<Response> insertUser(@Valid @RequestBody UserRequest userRequest){
        return response(userService.save(userRequest));
                //ResponseEntity.ok(userService.save(userRequest));

    }

    @GetMapping("/findUserId/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") long userId){
        return response(userService.getUser(userId));
    }

}
