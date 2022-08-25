package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ProductSizeDtoRes {
    private Long productOptionId;
    private Long sizeId;
    private String size;
    private int stock;
}
