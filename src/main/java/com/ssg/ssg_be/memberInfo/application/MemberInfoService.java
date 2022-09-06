package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.dto.MemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.dto.MemberInfoPutDtoReq;
import com.ssg.ssg_be.memberInfo.dto.MemberUpdatePasswordDtoReq;

public interface MemberInfoService {

    MemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException;
    void updateUserMember(MemberInfoPutDtoReq memberInfoPutDtoReq, Long userId) throws BaseException;
    void updateUserPassword(MemberUpdatePasswordDtoReq memberUpdatePasswordDtoReq, Long userId) throws BaseException;
}