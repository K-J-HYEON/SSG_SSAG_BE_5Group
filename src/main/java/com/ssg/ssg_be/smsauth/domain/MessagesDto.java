package com.ssg.ssg_be.smsauth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessagesDto {
    private String to;
    private String content;
}
