package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class CartCountPatchDtoReq {

    private Long cartId;
    private Long userId;
    private int count;

    public Cart toEntity(User user, ProductOption productOption) {
        return Cart.builder()
                .cartId(cartId)
                .productOption(productOption)
                .user(user)
                .count(count)
                .build();
    }
}
