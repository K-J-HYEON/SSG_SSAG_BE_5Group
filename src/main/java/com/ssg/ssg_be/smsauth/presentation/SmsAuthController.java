package com.ssg.ssg_be.smsauth.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.smsauth.application.SmsAuthService;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoReq;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ssg.config.BaseResponseStatus.AUTH_NUM_IS_NULL;
import static com.ssg.config.BaseResponseStatus.INVALID_PHONE_NUM;
import static com.ssg.utils.ValidationRegex.isRegexPhone;

@RequiredArgsConstructor
@RestController
@RequestMapping("comm-users/")
public class SmsAuthController {

    private SmsAuthService smsAuthService;

    @Autowired
    public SmsAuthController(SmsAuthService smsAuthService) {
        this.smsAuthService = smsAuthService;
    }

    @PostMapping("/auth/sms")
    public BaseResponse<SmsAuthDtoRes> sendMsg(@RequestBody SmsAuthDtoReq smsAuthDtoReq) throws JsonProcessingException {

        if(smsAuthDtoReq.getContent().equals("")) {
            return new BaseResponse<>(AUTH_NUM_IS_NULL);
        }

        if(!isRegexPhone(smsAuthDtoReq.getRecipientPhoneNumber())) {
            return new BaseResponse<>(INVALID_PHONE_NUM);
        }

        try {
            SmsAuthDtoRes smsAuthDtoRes = smsAuthService.sendMsg(smsAuthDtoReq);
            return new BaseResponse<>(smsAuthDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
