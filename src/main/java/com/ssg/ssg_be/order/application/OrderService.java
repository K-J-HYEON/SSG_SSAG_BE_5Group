package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.order.dto.OrderDtoList;
import com.ssg.ssg_be.order.dto.OrderUpdateDtoReq;
import com.ssg.ssg_be.order.dto.OrderListDtoReq;

import java.util.List;

public interface OrderService {
    void createOrder(OrderListDtoReq orderListDtoReq, Long userId) throws BaseException;
    List<OrderDtoList> retrieveOrders(Long userId) throws BaseException;
    void cancelOrder(OrderUpdateDtoReq updateDtoReq) throws BaseException;
    void updateOrder(OrderUpdateDtoReq updateDtoReq, Long userId, int type) throws BaseException;
    void deleteOrder(Long orderId) throws BaseException;

}
