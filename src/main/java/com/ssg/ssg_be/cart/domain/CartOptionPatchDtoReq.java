package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.ProductOption;
import lombok.Getter;

@Getter
public class CartOptionPatchDtoReq {

    private Long cartId;
    private Long userId;
    private Long productOptionId;
    private Long colorId;
    private Long sizeId;

    public Cart toEntity(Cart cart, ProductOption productOption) {
        return Cart.builder()
                .cartId(cartId)
                .productOption(productOption)
                .user(cart.getUser())
                .count(cart.getCount())
                .build();
    }
}
