package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReviewDto {
    private int reviewCount;
    private double reviewAvg;
}
