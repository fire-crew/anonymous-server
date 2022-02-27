package com.makefire.anonymous.rest.dto.response;

import com.makefire.anonymous.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

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
public class ResponseUser {

    private Long id; // id값
    private String userId; //사용자 아이디
    private String name; //이름
    private String password; //패스워드

    public ResponseUser(User user){
        this.id= user.getId();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
