package com.ssg.ssg_be.cart.dto;

import com.ssg.ssg_be.cart.domain.Cart;
import com.ssg.ssg_be.product.domain.ProductOption;
import lombok.Getter;

@Getter
public class CartOptionPatchDtoReq {

    private Long cartId;
    private Long productOptionId;

    public Cart toEntity(Cart cart, ProductOption productOption) {
        return Cart.builder()
                .cartId(cartId)
                .productOption(productOption)
                .user(cart.getUser())
                .count(cart.getCount())
                .build();
    }
}
