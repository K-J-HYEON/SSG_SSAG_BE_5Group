package com.ssg.ssg_be.smsauth.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssg.config.BaseException;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoReq;
import com.ssg.ssg_be.smsauth.domain.SmsAuthDtoRes;

public interface SmsAuthService {

    SmsAuthDtoRes sendMsg(SmsAuthDtoReq smsAuthDtoReq) throws BaseException, JsonProcessingException;
}
