package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.dto.UserDtoReq;

public interface SignupService {
    void addUser(UserDtoReq userDtoReq) throws BaseException;
    void checkUserId(String loginId) throws BaseException;
}
