package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDtoReq {

    private Long userId;
    private Long productOptionId;
    private int count;

    public Cart toEntity(User user, ProductOption productOption) {
        return Cart.builder()
                .user(user)
                .productOption(productOption)
                .count(count)
                .build();
    }

    public Cart toOriginEntity(User user, ProductOption productOption, Long cartId) {
        return Cart.builder()
                .cartId(cartId)
                .user(user)
                .productOption(productOption)
                .count(count)
                .build();
    }
}
