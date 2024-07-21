package com.stephenfu.users.service;

import com.stephenfu.users.dto.UserDto;
import com.stephenfu.users.model.User;
import com.stephenfu.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public UserDto getUserByUserId(Integer userId) {
        User user = new User(userId, "dummy@gmail.com", "Dummy User", 123456789);

        return createUserDtoFromEntity(user);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::createUserDtoFromEntity)
                .toList();
    }

    private UserDto createUserDtoFromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}
