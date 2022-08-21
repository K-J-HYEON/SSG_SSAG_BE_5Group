package com.ssg.ssg_be.smsauth.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SmsAuthDtoRes {
    private String requestId;
    private LocalDateTime requestTime;
    private String statusCode;
    private String statusName;
}
