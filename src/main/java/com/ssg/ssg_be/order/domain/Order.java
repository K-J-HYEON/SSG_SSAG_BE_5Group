package com.ssg.ssg_be.order.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddr;
import com.ssg.ssg_be.signup.domain.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 상태값 정하기
    @Column(columnDefinition = "tinyint(1) default 0")
    private int orderState;     // 주문 상태

    // 상태값 정하기
    @Column(columnDefinition = "tinyint(1) default 0")
    private int shippingState;  // 배송 상태

    @Column(nullable = false)
    private String shippingMsg;

    @ManyToOne
    @JoinColumn(name = "addrId", nullable = false)
    private ShippingAddr shippingAddr;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
