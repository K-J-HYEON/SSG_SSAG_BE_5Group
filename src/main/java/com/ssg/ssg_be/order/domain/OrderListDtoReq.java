package com.ssg.ssg_be.order.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderListDtoReq {
    private int refundType;
    private String recipient;
    private String recipientPhone;
    private String addrName;
    private String streetAddr;
    private String zipCode;
    private String shippingMsg;

    private List<OrderDtoReq> orderDtoReq;

    private List<Long> cartId;

    public OrderList toEntity(User user) {
        return OrderList.builder()
                .user(user)
                .refundType(refundType)
                .recipient(recipient)
                .recipientPhone(recipientPhone)
                .addrName(addrName)
                .streetAddr(streetAddr)
                .zipCode(zipCode)
                .shippingMsg(shippingMsg)
                .build();
    }
}
