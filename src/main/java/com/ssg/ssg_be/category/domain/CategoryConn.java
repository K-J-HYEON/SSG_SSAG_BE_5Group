package com.ssg.ssg_be.category.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryConn extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryConnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SmallCategory smallCategory;

    @Column(nullable = false)
    private Long mediumCategoryId;

    @Column(nullable = false)
    private Long largeCategoryId;

}
