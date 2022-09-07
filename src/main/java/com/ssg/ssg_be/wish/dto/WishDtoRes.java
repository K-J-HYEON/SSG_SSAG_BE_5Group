package com.ssg.ssg_be.wish.dto;

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
