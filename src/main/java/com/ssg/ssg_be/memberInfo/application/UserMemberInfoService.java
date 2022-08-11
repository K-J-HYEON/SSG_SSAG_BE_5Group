package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;

public interface UserMemberInfoService {
    UserMemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException;
}