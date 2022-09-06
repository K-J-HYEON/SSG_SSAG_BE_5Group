package com.ssg.ssg_be.product.dto;

import com.ssg.ssg_be.review.dto.ReviewTotalDto;
import com.ssg.ssg_be.wish.dto.WishDto;
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
