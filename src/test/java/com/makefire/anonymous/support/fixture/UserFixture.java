package com.makefire.anonymous.support.fixture;

import com.makefire.anonymous.domain.user.entity.User;

public class UserFixture {

    public static User createOneUser() {
        return User.builder()
                .name("test name")
                .build();
    }
}
