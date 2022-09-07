package com.ssg.ssg_be.nonmemberorder.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class NonMemberOrderListDtoReq {

    private String name;
    private String phone;
    private String email;
    private String streetAddr;
    private String zipCode;
    private String shippingMsg;

    private List<NonMemberOrderDtoReq> orderDtoReq;

    public NonMemberOrderList toEntity() {
        return NonMemberOrderList.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .streetAddr(streetAddr)
                .zipCode(zipCode)
                .shippingMsg(shippingMsg)
                .build();
    }
}
