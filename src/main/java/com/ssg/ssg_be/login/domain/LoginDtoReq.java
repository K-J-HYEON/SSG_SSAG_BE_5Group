package com.ssg.ssg_be.login.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;

@Getter
@Setter
public class LoginDtoReq {
    @Valid
    private String loginId;
    private String loginPwd;
}
