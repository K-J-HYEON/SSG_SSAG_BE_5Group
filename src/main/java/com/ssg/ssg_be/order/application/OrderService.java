package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.order.domain.OrderDtoListRes;
import com.ssg.ssg_be.order.domain.OrderListDtoReq;

import java.util.List;

public interface OrderService {
    void createOrder(OrderListDtoReq orderListDtoReq, Long userId) throws BaseException;

    List<OrderDtoListRes> retrieveOrders(Long userId) throws BaseException;
}
