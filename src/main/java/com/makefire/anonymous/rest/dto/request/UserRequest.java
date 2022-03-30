package com.makefire.anonymous.rest.dto.request;

import com.makefire.anonymous.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {

    private Long id; // id값
    private String userId; //아이디
    private String name; //이름
    private String password; //비밀번호

    @Builder
    public UserRequest (String userId, String name, String password){
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public static User toEntity(UserRequest userRequest){
        return User.builder().
                userId(userRequest.getUserId()).
                name(userRequest.getName()).
                password(userRequest.getPassword()).
                build();
    }
}
