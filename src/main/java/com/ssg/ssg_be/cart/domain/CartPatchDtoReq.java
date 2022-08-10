package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class CartPatchDtoReq {

    private Long cartId;
    private Long productId;
    private Long userId;
    private int count;

    public Cart toEntity(Product product, User user) {
        return Cart.builder()
                .cartId(cartId)
                .product(product)
                .user(user)
                .count(count)
                .build();
    }
}
