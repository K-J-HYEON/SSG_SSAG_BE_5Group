package com.ssg.ssg_be.signup.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDtoReq {
    private String loginId;
    private String loginPwd;
    private String name;
    private String email;
    private String phone;

    public User toEntity() {
        return User.builder()
                .loginId(name)
                .loginPwd(email)
                .name(name)
                .email(email)
                .phone(phone)
                .build();
    }
}
