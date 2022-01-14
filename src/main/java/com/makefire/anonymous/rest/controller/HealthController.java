package com.makefire.anonymous.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HealthController {

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "health Checking...";
    }
}
