package com.ssg.ssg_be.cart.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    //    product 엔티티 반영(product 컬럼 조인 시켜야함)
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    // user 엔티티 넣어서 반영
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private int count;


}
