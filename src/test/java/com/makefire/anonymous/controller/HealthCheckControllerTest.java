package com.makefire.anonymous.controller;

import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.extension.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class HealthCheckerControllerTest extends SpringMockMvcTestSupport {
    @DisplayName("서버체킹 초기 테스트 OK를 반환한다.")
    @Test
    void healthCheckTest() throws Exception {
        this.mockMvc.perform(get("/v1//healthCheck"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));
    }

}