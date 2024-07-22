package com.stephenfu.users.service;

import com.stephenfu.users.dto.UserDto;
import com.stephenfu.users.model.User;
import com.stephenfu.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public UserDto getUserByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return createUserDtoFromEntity(user);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::createUserDtoFromEntity)
                .toList();
    }

    public void updatePhoneNumber(Integer userId, Integer newPhoneNumber) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setPhoneNumber(newPhoneNumber);

        userRepository.save(user);
    }

    public void createUser(User user) {
        userRepository.save(user);
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
