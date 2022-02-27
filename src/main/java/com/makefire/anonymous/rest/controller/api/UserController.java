package com.makefire.anonymous.rest.controller.api;

import com.makefire.anonymous.rest.dto.request.RequestUser;
import com.makefire.anonymous.rest.dto.response.ResponseUser;
import com.makefire.anonymous.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserController
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 E2E
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * 22-02-16 김민철
 * ---------------------------------
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/userSignUp")
    public Long save(@RequestBody final RequestUser params){
        return userService.save(params);
    }

    @GetMapping("/findAll")
    public List<ResponseUser> findAll(){
        return userService.findAll();
    }

}
