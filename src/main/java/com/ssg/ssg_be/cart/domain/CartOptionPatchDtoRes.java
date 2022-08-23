package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.ProductOptionDtoRes;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartOptionPatchDtoRes {
    private Long cartId;
    private ProductOptionDtoRes productOption;
    private int count;
}
