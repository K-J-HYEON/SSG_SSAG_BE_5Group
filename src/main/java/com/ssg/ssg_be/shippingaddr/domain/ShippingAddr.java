package com.ssg.ssg_be.shippingaddr.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ShippingAddr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String addrName;    // 주소 별칭

    @Column(nullable = false)
    private String recipient;   // 받는 분

    @Column(nullable = false)
    private String phone;

    private String homePhone;

    @Column(nullable = false)
    private String zipCode;      // 우편번호

    @Column(nullable = false)
    private String streetAddr;   // 도로명 주소

    @Column(nullable = false)
    private String lotAddr;      // 지번 주소

    // 0: 기본 배송지 x, 1: 기본 배송지 o
    @Column(columnDefinition = "tinyint(1) default 0")
    private int addrDefault; // 기본 배송지 여부
}
