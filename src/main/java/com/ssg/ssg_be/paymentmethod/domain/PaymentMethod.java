package com.ssg.ssg_be.paymentmethod.domain;


import com.ssg.ssg_be.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long paymentId;


    // user 엔티티 넣어서 반영
//    @ManyToOne
//    @JoinColumn(name = "userId", nullable = false)
//    private User user;

    @Column(nullable = false)
    private String cardCompany;

    @Column(nullable = false)
    private int cardNumber;
}
