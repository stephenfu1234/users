package com.stephenfu.users.controller;

import com.stephenfu.users.dto.UserDto;
import com.stephenfu.users.model.User;
import com.stephenfu.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        UserDto user = usersService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    List<UserDto> findAll() {
        return usersService.findAll();
    }


}
