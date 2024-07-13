package com.stephenfu.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "Returned user id " + id;
    }

}
