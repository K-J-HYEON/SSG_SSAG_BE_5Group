package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.ProductOption;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartOptionPatchDtoRes {
    private Long cartId;
    private ProductOption productOption;
    private int count;
}
