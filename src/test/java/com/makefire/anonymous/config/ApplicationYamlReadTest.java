package com.makefire.anonymous.config;

import com.makefire.anonymous.config.web.ApplicationYamlRead;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class ApplicationYamlReadTest {
    @Autowired
    private ApplicationYamlRead applicationYamlRead;

    @Test
    void yamlFileTest(){
        assertAll(
                () -> {
                    assertThat(applicationYamlRead.getApi()).isEqualTo("https://kapi.kakao.com/");
                    assertThat(applicationYamlRead.getAuth()).isEqualTo("https://kauth.kakao.com/");
                }
        );
    }
}
