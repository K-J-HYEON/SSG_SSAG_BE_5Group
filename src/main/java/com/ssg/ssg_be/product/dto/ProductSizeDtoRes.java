package com.ssg.ssg_be.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductSizeDtoRes {
    private Long productOptionId;
    private Long sizeId;
    private String size;
    private int stock;
}
