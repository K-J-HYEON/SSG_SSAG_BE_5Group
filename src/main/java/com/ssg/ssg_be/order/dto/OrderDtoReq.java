package com.ssg.ssg_be.order.dto;

import com.ssg.ssg_be.order.domain.Orders;
import com.ssg.ssg_be.product.domain.ProductOption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDtoReq {
    private Long productOptionId;
    private int count;
    private int totalPayment;

    public Orders toEntity(OrderList orderList, ProductOption productOption) {
        return Orders.builder()
                .orderList(orderList)
                .productOption(productOption)
                .count(count)
                .totalPayment(totalPayment)
                .orderState(0)
                .shippingState(0)
                .build();
    }
}
