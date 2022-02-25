package com.makefire.anonymous.config.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kakao.url")
public class ApplicationYamlRead {
    private String api;
    private String auth;
}