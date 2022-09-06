package com.ssg.ssg_be.paymentmethod.dto;

import com.ssg.ssg_be.paymentmethod.domain.CardImg;

public interface PaymentMethodDtoRes {
    Long getPaymentId();
    String getCardCompany();
    String getCardNumber();
    CardImg getCardImg();
}
