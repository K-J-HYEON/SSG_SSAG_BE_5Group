package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductOptionDto {
    private Long productOptionId;
    private Long sizeId;
    private String size;
    private Long colorId;
    private String color;
    private String modelNumber;
    private int stock;
    private ProductDto productDto;
}
