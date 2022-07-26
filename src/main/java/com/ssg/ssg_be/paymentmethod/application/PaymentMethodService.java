package com.ssg.ssg_be.paymentmethod.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.paymentmethod.dto.PaymentMethodDtoReq;
import com.ssg.ssg_be.paymentmethod.dto.PaymentMethodDtoRes;

import java.util.List;

public interface PaymentMethodService {

    void createPaymentMethod(PaymentMethodDtoReq paymentMethodDtoReq, Long userId) throws BaseException;

    List<PaymentMethodDtoRes> retrievePaymentMethod(Long userId) throws BaseException;

    void deletePaymentMethod(Long paymentId) throws BaseException;
}
