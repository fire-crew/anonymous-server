package com.makefire.anonymous.rest.dto.response;

import com.makefire.anonymous.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.makefire.anonymous.rest.dto.response
 * fileName : Response
 * author : User
 * date : 2022-01-15
 * description :
 * ===========================================================
 * DATE AUTHOR NOTE
 * -----------------------------------------------------------
 * 2022-01-15 User 최초 생성
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {

    private Long id; // id값
    private String userId; //사용자 아이디
    private String name; //이름
    private String password; //패스워드

    @Builder
    public UserResponse(Long id, String userId, String name, String password){
        this.id= id;
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public static UserResponse from(User user){

        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

    public static List<UserResponse> fromList(List<User> users){
        List<UserResponse> userList = new ArrayList<>();

        users.forEach(user -> userList.add(
                UserResponse.builder()
                        .id(user.getId())
                        .userId(user.getUserId())
                        .name(user.getName())
                        .build()
        ));
        return userList;
    }

}
