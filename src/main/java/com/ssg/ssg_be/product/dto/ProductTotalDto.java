package com.ssg.ssg_be.product.dto;

import com.ssg.ssg_be.wish.dto.WishDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductTotalDto {
    private CategoryProductDto categoryProductDto;
    private ReviewDto reviewTotalDto;
    private WishDto wishDto;
}
