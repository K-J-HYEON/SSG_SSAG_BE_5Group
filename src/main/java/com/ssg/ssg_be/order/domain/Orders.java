package com.ssg.ssg_be.order.domain;

import com.ssg.config.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private OrderList orderList;

    @Column(nullable = false)
    private Long productOptionId;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int totalPayment;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int orderState;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int shippingState;

    private int courierCompany;
    private String waybillNumber;
}
