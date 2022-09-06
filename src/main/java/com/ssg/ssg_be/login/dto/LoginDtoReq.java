package com.ssg.ssg_be.login.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class LoginDtoReq {
    @Valid
    private String loginId;
    private String loginPwd;
}
