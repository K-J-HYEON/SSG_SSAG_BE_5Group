package com.ssg.ssg_be.memberInfo.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMemberInfoDtoReq {
    private String newPassword;
//    private String newPasswordConfirm;
    private String phone;
    private String email;

}
