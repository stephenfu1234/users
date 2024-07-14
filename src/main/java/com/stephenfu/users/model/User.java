package com.stephenfu.users.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private String email;
    private String name;

    public User(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
