package com.ssg.ssg_be.wish.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;

import java.sql.Timestamp;

public interface WishDtoRes {
    Long getWishId();
    Long getProductProductId();
    String getProductName();
    int getProductPrice();
    int getProductSale();
    Timestamp getProductSaleStartDate();
    Timestamp getProductSaleEndDate();
    String getProductImgOriginName();
    String getProductImgSaveName();
    String getProductImgUrl();
    Long getProductStoreStoreId();
    String getProductStoreName();
}
