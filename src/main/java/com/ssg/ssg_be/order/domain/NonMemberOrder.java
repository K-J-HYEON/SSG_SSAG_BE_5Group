package com.ssg.ssg_be.order.domain;

import com.ssg.ssg_be.product.domain.Product;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
public class NonMemberOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NonMemberId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String streetAddr;

//    private Timestamp createAt;
//    private Timestamp updateAt;
}