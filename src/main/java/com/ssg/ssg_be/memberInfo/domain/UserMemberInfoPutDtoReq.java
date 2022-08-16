package com.ssg.ssg_be.memberInfo.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class UserMemberInfoPutDtoReq {

    private String newPassword;
    private String phone;
    private String email;

    public UserMemberInfoDtoReq toEntity(User user) {
        return UserMemberInfoDtoReq.builder()
                .newPassword(newPassword)
                .phone(phone)
                .email(email)
                .build();
    }
}