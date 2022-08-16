package com.ssg.ssg_be.memberInfo.domain;

import lombok.Getter;

@Getter
public class SellerMemberInfoDtoReq {
    private String newPassword;
    private String newPasswordConfirm;
    private String phone;
    private String email;
}
