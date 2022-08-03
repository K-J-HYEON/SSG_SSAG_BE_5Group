package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.UserDtoReq;

public interface UserSignupService {
    void addUser(UserDtoReq userDtoReq) throws BaseException;
}
