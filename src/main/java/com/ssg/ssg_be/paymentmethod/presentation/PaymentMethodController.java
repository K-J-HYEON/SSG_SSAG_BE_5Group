package com.ssg.ssg_be.paymentmethod.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.paymentmethod.application.PaymentMethodService;
import com.ssg.ssg_be.paymentmethod.dto.PaymentMethodDtoReq;
import com.ssg.ssg_be.paymentmethod.dto.PaymentMethodDtoRes;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService, JwtTokenProvider jwtTokenProvider) {
        this.paymentMethodService = paymentMethodService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/payment")
    public BaseResponse<String> createPaymentMethod(@RequestBody PaymentMethodDtoReq paymentMethodDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            paymentMethodService.createPaymentMethod(paymentMethodDtoReq, userId);
            result = "결제 수단 추가에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/payment")
    public BaseResponse<List<PaymentMethodDtoRes>> retrievePaymentMethod() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<PaymentMethodDtoRes> paymentMethodDtoRes = paymentMethodService.retrievePaymentMethod(userId);
            return new BaseResponse<>(paymentMethodDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/payment/{paymentId}")
    public BaseResponse<String> deletePaymentMethod(@PathVariable Long paymentId) {
        String result = "";

        try {
            paymentMethodService.deletePaymentMethod(paymentId);
            result = "결제 수단 삭제에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
