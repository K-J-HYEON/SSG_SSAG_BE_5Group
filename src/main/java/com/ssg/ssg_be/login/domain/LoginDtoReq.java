package com.ssg.ssg_be.login.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDtoReq {
    private String loginId;
    private String loginPwd;
}
