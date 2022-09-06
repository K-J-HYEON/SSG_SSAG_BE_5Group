package com.ssg.ssg_be.nonmemberorder.dto;

import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrder;
import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrderList;
import lombok.Getter;

@Getter
public class NonMemberOrderDtoReq {
    private Long productOptionId;
    private int count;
    private int totalPayment;

    public NonMemberOrder toEntity(NonMemberOrderList nonMemberOrderList) {
        return NonMemberOrder.builder()
                .nonMemberOrderList(nonMemberOrderList)
                .productOptionId(productOptionId)
                .count(count)
                .totalPayment(totalPayment)
                .orderState(0)
                .shippingState(0)
                .build();
    }
}
