package com.ssg.ssg_be.cart.dto;

import com.ssg.ssg_be.product.dto.ProductOptionDtoRes;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartOptionPatchDtoRes {
    private Long cartId;
    private ProductOptionDtoRes productOption;
    private int count;
}
