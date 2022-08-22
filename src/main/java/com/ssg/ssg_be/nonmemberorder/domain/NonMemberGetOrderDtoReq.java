package com.ssg.ssg_be.nonmemberorder.domain;

import lombok.Getter;

@Getter
public class NonMemberGetOrderDtoReq {
    private String name;
    private String phone;
    private Long nonMemberOrderListId;
}
