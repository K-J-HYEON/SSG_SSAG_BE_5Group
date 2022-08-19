package com.ssg.ssg_be.review.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;

public class ReviewPatchDtoReq {

    private Long reviewId;
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
