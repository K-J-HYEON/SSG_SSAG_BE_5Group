package com.ssg.ssg_be.wish.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
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
