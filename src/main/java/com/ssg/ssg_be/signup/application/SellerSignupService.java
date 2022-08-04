package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.SellerDtoReq;

public interface SellerSignupService {
    void addSeller(SellerDtoReq sellerDtoReq) throws BaseException;

}
