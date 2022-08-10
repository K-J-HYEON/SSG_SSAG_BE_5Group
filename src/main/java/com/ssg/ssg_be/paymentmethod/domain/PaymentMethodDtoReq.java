package com.ssg.ssg_be.paymentmethod.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class PaymentMethodDtoReq {

    private Long userId;
    private String cardCompany;
    private String cardNumber;

    public PaymentMethod toEntity(User user) {
        return PaymentMethod.builder()
                .user(user)
                .cardCompany(cardCompany)
                .cardNumber(cardNumber)
                .build();
    }
}
