package com.makefire.anonymous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class AnonymousApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnonymousApplication.class, args);
    }

}
