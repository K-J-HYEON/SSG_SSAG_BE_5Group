package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductOptionDtoRes {
    private Long productOptionId;
    private Size size;
    private Color color;
    private String modelNumber;
    private int stock;
}
