package com.ssg.ssg_be.product.domain;

import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductDtoRes {
    private CategoryProductDtoRes categoryProductDtoRes;
    private ReviewTotalDto reviewTotalDto;
}
