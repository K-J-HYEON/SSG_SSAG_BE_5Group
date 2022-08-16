package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoPutDtoReq;
import com.ssg.ssg_be.memberInfo.domain.MemberUpdatePasswordDtoReq;

public interface MemberInfoService {

    MemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException;
    void updateUserMember(MemberInfoPutDtoReq memberInfoPutDtoReq) throws BaseException;
    void updateUserPassword(MemberUpdatePasswordDtoReq memberUpdatePasswordDtoReq) throws BaseException;
}