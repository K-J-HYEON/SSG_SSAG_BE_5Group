package com.ssg.ssg_be.cart.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.signup.domain.User;
import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "productOptionId", nullable = false)
    private ProductOption productOption;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private int count;


}
