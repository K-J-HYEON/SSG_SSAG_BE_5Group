package com.ssg.ssg_be.paymentmethod.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethodDtoReq;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethodDtoRes;
import com.ssg.ssg_be.paymentmethod.infrastucture.PaymentMethodRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    @Autowired
    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository, UserRepository userRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createPaymentMethod(PaymentMethodDtoReq paymentMethodDtoReq) throws BaseException {

        User user = userRepository.getById(paymentMethodDtoReq.getUserId());

        try {
            paymentMethodRepository.save(paymentMethodDtoReq.toEntity(user));
        } catch(Exception exception) {
            throw new BaseException(PAYMENT_METHOD_INSERT_FAILED);
        }
    }

    @Override
    public List<PaymentMethodDtoRes> retrievePaymentMethod(Long userId) throws BaseException {

        try {
            return paymentMethodRepository.findByUserUserId(userId);
        } catch(Exception exception) {
            throw new BaseException(PAYMENT_METHOD_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deletePaymentMethod(Long paymentId) throws BaseException {

        try {
            paymentMethodRepository.deleteById(paymentId);
        } catch(Exception exception) {
            throw new BaseException(PAYMENT_METHOD_DELETE_FAILED);
        }
    }
}
