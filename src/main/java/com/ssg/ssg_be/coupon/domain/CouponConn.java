package com.ssg.ssg_be.coupon.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.signup.domain.User;

import javax.persistence.*;

@Entity
public class CouponConn extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponConnId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Coupon coupon;
}
