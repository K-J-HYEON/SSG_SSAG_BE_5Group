package com.ssg.ssg_be.review.dto;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.review.domain.Review;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class ReviewDtoReq {

    private Long productId;
    private String content;
    private int score;

    public Review toEntity(Product product, User user) {
        return Review.builder()
                .product(product)
                .user(user)
                .content(content)
                .score(score)
                .build();
    }
}
