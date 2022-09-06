package com.ssg.ssg_be.wish.dto;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.wish.domain.Wish;
import lombok.Getter;

@Getter
public class WishDtoReq {

    private Long productId;

    public Wish toEntity(Product product, User user) {
        return Wish.builder()
                .product(product)
                .user(user)
                .build();
    }
}
