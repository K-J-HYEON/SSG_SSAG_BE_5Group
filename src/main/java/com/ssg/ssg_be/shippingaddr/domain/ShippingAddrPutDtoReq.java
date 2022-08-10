package com.ssg.ssg_be.shippingaddr.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class ShippingAddrPutDtoReq {

    private Long addrId;
    private Long userId;
    private String addrName;    // 주소 별칭
    private String recipient;   // 받는 분
    private String phone;
    private String homePhone;
    private String zipCode;      // 우편번호
    private String streetAddr;   // 도로명 주소
    private String lotAddr;      // 지번 주소

    // 0: 기본 배송지 x, 1: 기본 배송지 o
    private int addrDefault; // 기본 배송지 여부

    public ShippingAddr toEntity(User user) {
        return ShippingAddr.builder()
                .addrId(addrId)
                .user(user)
                .addrName(addrName)
                .recipient(recipient)
                .phone(phone)
                .homePhone(homePhone)
                .zipCode(zipCode)
                .streetAddr(streetAddr)
                .lotAddr(lotAddr)
                .addrDefault(addrDefault)
                .build();
    }
}
