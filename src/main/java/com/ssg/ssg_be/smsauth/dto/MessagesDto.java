package com.ssg.ssg_be.smsauth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessagesDto {
    private String to;
    private String content;
}
