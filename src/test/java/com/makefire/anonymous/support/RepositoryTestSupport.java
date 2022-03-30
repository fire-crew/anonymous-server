package com.makefire.anonymous.support;

import com.makefire.anonymous.config.JpaTestConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * packageName : com.makefire.anonymous.support
 * fileName : RepositoryTestSupport
 * author : kjho94
 * date : 2022-03-15
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-15  kjho94    최초 생성
 * ---------------------------------
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(JpaTestConfig.class)
public abstract class RepositoryTestSupport {
}
