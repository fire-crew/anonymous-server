package com.makefire.anonymous.config.cache;

import com.makefire.anonymous.config.web.cache.EhCacheConfiguration;
import com.makefire.anonymous.support.SpringMockMvcTestSupport;
import com.makefire.anonymous.support.extension.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import javax.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EhCacheConfigurationTest extends SpringMockMvcTestSupport {

    private EhCacheConfiguration cut;

    @MockBean
    private CacheManager cacheManager;

    @BeforeEach
    void setUp() {
        cut = new EhCacheConfiguration();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void checkIfCacheIsCalled() {
        assertThat(cut.cacheManagerCustomizer()).isInstanceOf(JCacheManagerCustomizer.class);
    }
}