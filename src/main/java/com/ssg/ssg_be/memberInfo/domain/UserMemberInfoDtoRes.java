package com.ssg.ssg_be.memberInfo.domain;
import lombok.Builder;

// 회원아이디 이름 휴대폰번호 이메일

// toEntity, toDto 변환방법
@Builder
public class UserMemberInfoDtoRes {
    private Long userId;
    private String loginId;
    private String name;
    private String phone;
    private String email;

}
