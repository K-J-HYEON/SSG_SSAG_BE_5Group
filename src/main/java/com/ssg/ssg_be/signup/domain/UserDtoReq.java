package com.ssg.ssg_be.signup.domain;

import lombok.Builder;
import lombok.Getter;
import org.yaml.snakeyaml.error.Mark;

import java.sql.Timestamp;

@Getter
public class UserDtoReq {
    private String loginId;
    private String loginPwd;
    private String name;
    private String email;
    private String phone;

    private int marketing1;
    private Timestamp updateAt1;
    private int marketing2;
    private Timestamp updateAt2;
    private int marketing3;
    private Timestamp updateAt3;

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
