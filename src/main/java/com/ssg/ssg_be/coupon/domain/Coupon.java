package com.ssg.ssg_be.coupon.domain;

import javax.persistence.*;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long couponId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int couponType;

    @Column(nullable = false)
    private int couponNumber;

    @Column(nullable = true)
    private int discountRate;

    @Column(nullable = true)
    private int maxDiscount;

    @Column(nullable = true)
    private int ableAmount;
}
