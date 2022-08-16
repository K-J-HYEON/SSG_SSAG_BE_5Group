package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoReq;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoRes;

public interface SellerMemberInfoService {
    SellerMemberInfoDtoRes retrieveSellerMember(Long sellerId) throws BaseException;
    void updateSellerInfo(SellerMemberInfoDtoReq sellerMemberInfoDtoReq) throws BaseException;
}
