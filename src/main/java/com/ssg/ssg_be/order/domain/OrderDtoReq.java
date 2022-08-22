package com.ssg.ssg_be.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDtoReq {
    private Long productOptionId;
    private int count;
    private int totalPayment;

    public Orders toEntity(OrderList orderList) {
        return Orders.builder()
                .orderList(orderList)
                .productOptionId(productOptionId)
                .count(count)
                .totalPayment(totalPayment)
                .orderState(0)
                .shippingState(0)
                .build();
    }
}
