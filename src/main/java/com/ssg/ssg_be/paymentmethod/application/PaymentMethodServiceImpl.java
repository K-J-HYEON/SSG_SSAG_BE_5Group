package com.ssg.ssg_be.paymentmethod.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.paymentmethod.domain.CardImg;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethodDtoReq;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethodDtoRes;
import com.ssg.ssg_be.paymentmethod.infrastucture.CardImgRepository;
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
    private final CardImgRepository cardImgRepository;

    @Autowired
    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, CardImgRepository cardImgRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.cardImgRepository = cardImgRepository;
    }

    @Override
    public void createPaymentMethod(PaymentMethodDtoReq paymentMethodDtoReq, Long userId) throws BaseException {

        User user = userRepository.getById(userId);
        CardImg cardImg = cardImgRepository.findByCardCompany(paymentMethodDtoReq.getCardCompany());

        try {
            paymentMethodRepository.save(paymentMethodDtoReq.toEntity(user, cardImg));
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
