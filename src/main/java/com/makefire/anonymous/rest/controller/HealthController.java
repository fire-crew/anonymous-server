package com.makefire.anonymous.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
@Controller
public class HealthController {

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "health Checking...";
    }
}
