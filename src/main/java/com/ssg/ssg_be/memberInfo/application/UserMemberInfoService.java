package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoPutDtoReq;

public interface UserMemberInfoService {

    UserMemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException;
    void updateUserMember(UserMemberInfoPutDtoReq userMemberInfoPutDtoReq) throws BaseException;
}