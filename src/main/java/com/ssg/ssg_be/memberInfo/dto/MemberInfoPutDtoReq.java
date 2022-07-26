package com.ssg.ssg_be.memberInfo.dto;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class MemberInfoPutDtoReq {

    private String phone;
    private String email;

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
                .loginDate(user.getLoginDate())
                .status(user.getStatus())
                .phone(phone)
                .email(email)
                .userRole(user.getUserRole())
                .build();
    }
}