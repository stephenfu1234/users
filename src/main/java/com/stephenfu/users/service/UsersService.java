package com.stephenfu.users.service;

import com.stephenfu.users.dto.UserDto;
import com.stephenfu.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public UserDto getUserByUserId(Integer userId) {
        User user = new User(userId, "stephenfu1@gmail.com", "Stephen Fu");

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

}
