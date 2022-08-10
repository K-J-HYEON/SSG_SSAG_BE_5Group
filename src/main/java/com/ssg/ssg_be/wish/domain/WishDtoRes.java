package com.ssg.ssg_be.wish.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;

public interface WishDtoRes {
    Long getWishId();
    Product getProduct();
    User getUser();
}
