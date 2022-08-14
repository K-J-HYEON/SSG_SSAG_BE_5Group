package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.login.domain.LoginDtoReq;

public interface SellerLoginService {
    String sellerLogin(LoginDtoReq loginDtoReq) throws BaseException;
}
