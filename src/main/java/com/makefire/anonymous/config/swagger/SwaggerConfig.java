package com.makefire.anonymous.config.swagger;

/**
 *packageName:com.makefire.anonymous
 *fileName:SwaggerConfig
 *author:최푸름
 *date:22-01-14
 *description:스웨거설정클래스
 *=================================
 *DATEAUTHORNOTE
 *22-01-15최푸름
 *---------------------------------
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

                @Bean
                public Docket api() {
                        return new Docket(DocumentationType.SWAGGER_2)
                                .select()
                                .apis(RequestHandlerSelectors.any())
                                .paths(PathSelectors.any())
                                .build();
                }
        }
