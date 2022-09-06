package com.ssg.ssg_be.paymentmethod.dto;

import com.ssg.ssg_be.paymentmethod.domain.CardImg;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethod;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class PaymentMethodDtoReq {

    private String cardCompany;
    private String cardNumber;

    public PaymentMethod toEntity(User user, CardImg cardImg) {
        return PaymentMethod.builder()
                .user(user)
                .cardCompany(cardCompany)
                .cardNumber(cardNumber)
                .cardImg(cardImg)
                .build();
    }
}
