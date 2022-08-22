package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productOptionId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sizeId", nullable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "colorId", nullable = false)
    private Color color;

    @Column(nullable = false)
    private String modelNumber;

    @Column(nullable = false)
    private int stock;

}
