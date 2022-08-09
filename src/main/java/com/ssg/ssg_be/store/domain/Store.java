package com.ssg.ssg_be.store.domain;


import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethod;
import com.ssg.ssg_be.signup.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int state;

    // sell 엔티티 넣어서 반영
    // 비식별자 OneToOne 매핑인데 어떻게 해결해야 할지 고민중
    @OneToOne
    @JoinColumn(name = "sellerId", nullable = false)
    private Seller seller;
}
