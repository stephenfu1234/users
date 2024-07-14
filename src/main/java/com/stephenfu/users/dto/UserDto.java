package com.stephenfu.users.dto;

import lombok.*;

@Getter
@Builder
public class UserDto {

    private final Integer id;
    private final String email;
    private final String name;

}
