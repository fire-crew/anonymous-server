package com.makefire.anonymous.domain;

import com.makefire.anonymous.domain.user.entity.User;
import com.makefire.anonymous.domain.user.repository.UserRepository;
import com.makefire.anonymous.support.RepositoryTestSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest extends RepositoryTestSupport {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .name("test name")
                .build();
        userRepository.save(user);
    }

    @Test
    @DisplayName("getUser 테스트")
    void getUser() {
//        User user = User.builder()
//                .name("test name")
//                .build();
//        userRepository.save(user);

        User result = userRepository.getUser("test name");

        Assertions.assertAll(
                () -> assertEquals(result.getName(), "test name")
        );
    }

    @Test
    @DisplayName("getUserList 테스트")
    void getUserListTest() {

        List<User> userList = userRepository.getUserList();

        Assertions.assertAll(
                () -> assertEquals(userList.size(), 1)
        );
    }
}
