package com.ssg.ssg_be.servicecenter.store;


import com.ssg.ssg_be.paymentmethod.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int state;

    @OneToOne
    @Column(nullable = false)
    @JoinColumn(name = "seller_id")
    private Long sellerId;

}
