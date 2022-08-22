package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.order.domain.OrderListDtoReq;

public interface OrderService {
    void createOrder(OrderListDtoReq orderListDtoReq, Long userId) throws BaseException;
}
