package com.ssg.ssg_be.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReviewDto {
    private Integer reviewCount;
    private Double reviewAvg;
}
