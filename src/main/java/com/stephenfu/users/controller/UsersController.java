package com.stephenfu.users.controller;

import com.stephenfu.users.dto.UserDto;
import com.stephenfu.users.model.User;
import com.stephenfu.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        UserDto user = usersService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    List<UserDto> findAll() {
        return usersService.findAll();
    }

    @PutMapping("/users/{userId}")
    ResponseEntity<Void> updateUser(@PathVariable Integer userId) {
        Random random = new Random();
        int newPhoneNumber = random.nextInt(999999999 - 100000000) + 100000000;
        usersService.updatePhoneNumber(userId, newPhoneNumber);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users/{usersName}")
    ResponseEntity<Void> createUser(@PathVariable String usersName) {
        Random random = new Random();
        int newPhoneNumber = random.nextInt(999999999 - 100000000) + 100000000;

        User user = new User();
        user.setName(usersName);
        user.setPhoneNumber(newPhoneNumber);
        user.setEmail(usersName + "@gmail.com");

        usersService.createUser(user);

        return ResponseEntity.noContent().build();
    }
}
