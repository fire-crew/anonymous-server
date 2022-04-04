package com.makefire.anonymous.domain;

import com.makefire.anonymous.domain.user.entity.User;
import com.makefire.anonymous.domain.user.repository.UserRepository;
import com.makefire.anonymous.support.RepositoryTestSupport;
import com.makefire.anonymous.support.fixture.UserFixture;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest extends RepositoryTestSupport {

    @Autowired
    private UserRepository userRepository;

    @Nested
    @DisplayName("test name 이라는 이름을 가진 user 객체를 저장하고,")
    class SaveUser {

        @BeforeEach
        void setUp() {
            User user = UserFixture.createOneUser();
            userRepository.save(user);
        }

        @Test
        @DisplayName("test name 이라는 이름을 가진 user 를 가져온다.")
        void getUser() {
            User result = userRepository.getUser("test name");

            Assertions.assertAll(
                    () -> assertEquals(result.getName(), "test name")
            );
        }

        @Test
        @DisplayName("테이블 내에 모든 데이터를 가져온다.")
        void getUserListTest() {
            List<User> userList = userRepository.getUserList();

            Assertions.assertAll(
                    () -> assertEquals(userList.size(), 1)
            );
        }

        @Test
        @DisplayName("test name 이름을 가진 user 를 new test name 으로 업데이트 한다.")
        void updateUserTest() {
            String newName = "new test name";
            User user = userRepository.getUser("test name");
            long number = userRepository.updateUser(user.getName(), newName);

            Assertions.assertAll(
                    () -> assertEquals(number, 1L)
            );
        }

        @Test
        @DisplayName("test name 이름을 가진 user 를 삭제한다.")
        void deleteUserTest() {
            long number = userRepository.deleteUser("test name");

            Assertions.assertAll(
                    () -> assertEquals(number, 1L)
            );
        }
    }

    @Test
    @DisplayName("test name 이름을 가진 user 를 저장한다.")
    void insertUserTest() {
        User user = UserFixture.createOneUser();

        Long number = userRepository.insertUser(user);

        Assertions.assertAll(
                () -> assertEquals(number, 1L)
        );
    }
}
