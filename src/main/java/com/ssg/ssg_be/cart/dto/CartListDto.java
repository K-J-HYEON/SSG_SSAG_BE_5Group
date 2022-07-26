package com.ssg.ssg_be.cart.dto;

import com.ssg.ssg_be.cart.domain.Cart;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartListDto {
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
