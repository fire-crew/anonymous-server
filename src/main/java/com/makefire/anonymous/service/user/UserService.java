package com.makefire.anonymous.service.user;

import com.makefire.anonymous.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
