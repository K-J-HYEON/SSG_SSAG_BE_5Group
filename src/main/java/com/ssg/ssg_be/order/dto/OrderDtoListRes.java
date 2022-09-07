package com.ssg.ssg_be.order.dto;

import com.ssg.ssg_be.signup.dto.UserDtoRes;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDtoListRes {
    Long getOrderListId();

    UserDtoRes getUser();

    int getRefundType();

    String getRecipient();

    String gerRecipientPhone();

    String getAddrName();

    String getStreetAddr();

    String getZipCode();

    String getShippingMsg();

    LocalDateTime getCreateAt();

    List<OrderDtoRes> getOrders();
}
