package com.ssg.ssg_be.memberInfo.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class UserMemberInfoPutDtoReq {

    private Long userId;
    private String newPassword;
    private String phone;
    private String email;

    public User toEntity(User user) {
        return User.builder()
                .userId(userId)
                .loginId(user.getLoginId())
                .loginPwd(newPassword)
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .grade(user.getGrade())
                .userType(user.getUserType())
                .loginDate(user.getLoginDate())
                .status(user.getStatus())
                .phone(phone)
                .email(email)
                .build();
    }
}