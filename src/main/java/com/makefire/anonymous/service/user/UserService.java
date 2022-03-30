package com.makefire.anonymous.service.user;

import com.makefire.anonymous.domain.user.entity.User;
import com.makefire.anonymous.domain.user.repository.UserRepository;
import com.makefire.anonymous.exception.BadRequestException;
import com.makefire.anonymous.rest.dto.request.UserRequest;
import com.makefire.anonymous.rest.dto.response.UserResponse;
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

    //사용자 생성
    @Transactional
    public UserResponse save(UserRequest userRequest){

        User user = UserRequest.toEntity(userRequest);
        return UserResponse.from(userRepository.save(user));
    }

    //사용자 조회
    public UserResponse getUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()
        -> new BadRequestException("해당 사용자를 찾을수없습니다. 사용자 id를 확인해주세요."));
        return UserResponse.from(user);
    }

    //사용자 목록
    public List<UserResponse> getUserList(){
        List<User> userList = userRepository.findAll();
        return UserResponse.fromList(userList);
    }

}

