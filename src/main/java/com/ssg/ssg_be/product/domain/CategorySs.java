package com.ssg.ssg_be.product.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class CategorySs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorySsId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "categorySId", nullable = false)
    private CategoryS categoryS;

    @Column(nullable = false)
    private String name;
}
