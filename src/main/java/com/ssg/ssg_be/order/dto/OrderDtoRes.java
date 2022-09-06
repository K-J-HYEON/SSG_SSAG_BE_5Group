package com.ssg.ssg_be.order.dto;

import com.ssg.ssg_be.product.domain.ProductOption;

public interface OrderDtoRes {
    Long getOrderId();
    int getCount();
    int getTotalPayment();
    int getOrderState();
    int getShippingState();
    int getCourierCompany();
    String getWaybillNumber();
    ProductOption getProductOption();
}
