package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.login.domain.LoginDtoReq;

public interface UserLoginService {

    String userLogin(LoginDtoReq loginDtoReq) throws BaseException;
}
