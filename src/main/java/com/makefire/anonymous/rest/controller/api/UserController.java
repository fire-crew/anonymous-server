package com.makefire.anonymous.rest.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserController
 * author : 최푸름
 * date : 22-01-14
 * description : 유저 E2E
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@Controller
public class UserController {


    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi getMethod";

    }
}
