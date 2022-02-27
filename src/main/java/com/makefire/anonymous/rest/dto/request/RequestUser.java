package com.makefire.anonymous.rest.dto.request;

import com.makefire.anonymous.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUser {

    private Long id; // id값
    private String userId; //아이디
    private String name; //이름
    private String password; //비밀번호

    public User toEntity(){
        return User.builder().
                userId(userId).
                name(name).
                password(password).
                build();
    }
}
