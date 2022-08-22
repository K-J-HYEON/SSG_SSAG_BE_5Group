package com.ssg.ssg_be.nonmemberorder.domain;

public interface NonMemberOrderDtoRes {
    Long getNonMemberOrderId();
    Long getProductOptionId();
    int getCount();
    int getTotalPayment();
    int getOrderState();
    int getShippingState();
    int getCourierCompany();
    String getWaybillNumber();
}
