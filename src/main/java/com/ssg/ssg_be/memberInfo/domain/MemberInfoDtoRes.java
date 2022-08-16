package com.ssg.ssg_be.memberInfo.domain;
import lombok.Builder;
import lombok.Getter;

// 회원아이디 이름 휴대폰번호 이메일

// toEntity, toDto 변환방법
@Builder
@Getter
public class MemberInfoDtoRes {
    private Long userId;
    private String loginId;
    private String name;
    private String phone;
    private String email;
}
