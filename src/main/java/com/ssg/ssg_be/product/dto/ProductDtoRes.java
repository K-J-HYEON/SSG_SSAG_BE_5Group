package com.ssg.ssg_be.product.dto;

import com.ssg.ssg_be.review.dto.ReviewTotalDto;
import com.ssg.ssg_be.wish.dto.WishDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDtoRes {
    private CategoryProductDtoRes categoryProductDtoRes;
    private ReviewTotalDto reviewTotalDto;
    private WishDto wishDto;
}
