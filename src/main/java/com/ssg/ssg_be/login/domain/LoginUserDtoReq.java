package com.ssg.ssg_be.login.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class LoginUserDtoReq {

    private Timestamp loginDate;

    public User toEntity(User user) {
        return User.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .loginPwd(user.getLoginPwd())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .grade(user.getGrade())
                .userType(user.getUserType())
                .loginDate(loginDate)
                .status(user.getStatus())
                .userRole(user.getUserRole())
                .build();
    }
}
