package com.makefire.anonymous.service.user;

import com.makefire.anonymous.domain.user.entity.User;
import com.makefire.anonymous.domain.user.repository.UserRepository;
import com.makefire.anonymous.rest.dto.request.RequestUser;
import com.makefire.anonymous.rest.dto.response.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *packageName : com.makefire.anonymous
 * fileName : UserService
 * author : 최푸름
 * date : 22-01-14
 * description : User 비즈니스로직
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    @Transactional
    public Long save(final RequestUser params){

        User user = userRepository.save(params.toEntity());
        return user.getId();
    }

    //유저 조회
    public List<ResponseUser> findAll(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(ResponseUser::new).collect(Collectors.toList());
    }

    //유저 정보 업데이트

}

