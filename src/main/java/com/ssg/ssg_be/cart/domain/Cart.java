package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    //    product 엔티티 반영(product 컬럼 조인 시켜야함)
//    @ManyToOne
//    @JoinColumn(name = "productId")
//    private Product product;


    // user 엔티티 넣어서 반영
//    @ManyToOne
//    @JoinColumn(name = "userId", nullable = false)
//    private User user;

    @Column(nullable = false)
    private int count;


}
