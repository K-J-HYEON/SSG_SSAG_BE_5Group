package com.ssg.ssg_be.coupon.domain;

import com.ssg.ssg_be.BaseTimeEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Coupon extends BaseTimeEntity {

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

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

}
