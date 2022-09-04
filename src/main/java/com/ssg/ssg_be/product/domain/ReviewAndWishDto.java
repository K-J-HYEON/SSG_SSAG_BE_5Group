package com.ssg.ssg_be.product.domain;

import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import com.ssg.ssg_be.wish.domain.WishDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ReviewAndWishDto {
    List<ReviewTotalDto> reviewTotalDtos;
    List<WishDto> wishIdDtos;
}
