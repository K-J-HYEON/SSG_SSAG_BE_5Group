package com.ssg.ssg_be.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {
    private Long productId;
    private String name;
    private int price;
    private int sale;
    private String imgUrl;
}
