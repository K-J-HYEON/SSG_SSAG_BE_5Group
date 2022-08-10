package com.ssg.ssg_be.cart.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;

public interface CartDtoRes {
    Long getCartId();
    Product getProduct();
    int getCount();
}
