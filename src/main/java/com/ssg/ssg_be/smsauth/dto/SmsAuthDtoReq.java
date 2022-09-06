package com.ssg.ssg_be.smsauth.dto;

import lombok.Getter;

@Getter
public class SmsAuthDtoReq {
    private String recipientPhoneNumber;
    private String content;
}
