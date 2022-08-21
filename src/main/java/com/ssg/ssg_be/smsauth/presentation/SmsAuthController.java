package com.ssg.ssg_be.smsauth.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.smsauth.application.SmsAuthService;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoReq;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comm-users/")
public class SmsAuthController {

    private final SmsAuthService smsAuthService;

    @Autowired
    public SmsAuthController(SmsAuthService smsAuthService) {
        this.smsAuthService = smsAuthService;
    }

    @PostMapping("/auth/sms")
    public BaseResponse<SmsAuthDtoRes> sendMsg(@RequestBody SmsAuthDtoReq smsAuthDtoReq) throws JsonProcessingException {
        try {
            SmsAuthDtoRes smsAuthDtoRes = smsAuthService.sendMsg(smsAuthDtoReq);
            return new BaseResponse<>(smsAuthDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
