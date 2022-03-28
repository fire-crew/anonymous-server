package com.makefire.anonymous.support;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * packageName : com.makefire.anonymous.support
 * fileName : ControllerTestSupport
 * author : kjho94
 * date : 2022-03-15
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-15  kjho94    최초 생성
 * ---------------------------------
 */
@WebMvcTest
@ActiveProfiles("test")
public abstract class ControllerTestSupport {
}
