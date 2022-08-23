package com.ssg.ssg_be.order.domain;

public interface OrderDtoRes {
    Long getOrderId();
    Long getProductOptionId();
    int getCount();
    int getTotalPayment();
    int getOrderState();
    int getShippingState();
    int getCourierCompany();
    String getWaybillNumber();
}
