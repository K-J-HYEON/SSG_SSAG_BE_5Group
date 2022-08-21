package com.ssg.ssg_be.smsauth.domain;

import lombok.Getter;

@Getter
public class SmsAuthDtoReq {
    private String recipientPhoneNumber;
    private String content;
}
