package com.ssg.ssg_be.cart.dto;

import com.ssg.ssg_be.product.domain.ProductOption;

public interface CartDtoRes {
    Long getCartId();
    ProductOption getProductOption();
    int getCount();
}
