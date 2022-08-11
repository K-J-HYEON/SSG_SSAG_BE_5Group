package com.ssg.ssg_be.memberInfo.domain;
import lombok.Builder;

// 회원아이디 이름 휴대폰 번호 이메일
@Builder
public class SellerMemberInfoDtoRes {
    private Long sellerId;
    private String loginId;
    private String name;
    private String phone;
    private String email;




}


