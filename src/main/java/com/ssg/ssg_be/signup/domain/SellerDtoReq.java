package com.ssg.ssg_be.signup.domain;

import lombok.Getter;

@Getter
public class SellerDtoReq {
    private String loginId;
    private String loginPwd;
    private String name;
    private String email;
    private String corporationName;
    private String corporationNumber;
    private String phone;

    public Seller toEntity() {
        return Seller.builder()
                .loginId(loginId)
                .loginPwd(loginPwd)
                .name(name)
                .email(email)
                .corporationName(corporationName)
                .corporationNumber(corporationNumber)
                .phone(phone)
                .build();
    }
}
