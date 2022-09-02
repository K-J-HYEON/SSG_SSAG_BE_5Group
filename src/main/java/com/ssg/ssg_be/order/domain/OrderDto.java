package com.ssg.ssg_be.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long orderId;
    private int count;
    private int totalPayment;
    private int orderState;
    private int shippingState;
    private int courierCompany;
    private String waybillNumber;

    private Long productOptionId;
    private Long productId;
    private String productName;
    private int price;
    private int sale;
    private String imgUrl;
    private String storeName;
    private String size;
    private String color;
}
