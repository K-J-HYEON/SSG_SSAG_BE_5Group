package com.ssg.ssg_be.category.domain;

import com.ssg.ssg_be.product.domain.Product;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class CategoryConn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryConnId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "categoryS")
    private Category category;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

}
