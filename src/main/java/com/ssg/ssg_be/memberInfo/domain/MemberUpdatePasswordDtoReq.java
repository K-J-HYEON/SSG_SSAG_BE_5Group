package com.ssg.ssg_be.memberInfo.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberUpdatePasswordDtoReq {

    private Long userId;
    private String newPassword;

    public User toEntity(User user) {
        return User.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .loginPwd(newPassword)
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .grade(user.getGrade())
                .userType(user.getUserType())
                .loginDate(user.getLoginDate())
                .status(user.getStatus())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
