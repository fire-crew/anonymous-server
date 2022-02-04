package com.makefire.anonymous.support;

import com.makefire.anonymous.AnonymousApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnonymousApplication.class)
@ActiveProfiles("test")
public abstract class SpringTestSupport {
}
