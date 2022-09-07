package com.ssg.ssg_be.product.domain;

import java.time.LocalDateTime;

public interface Test {
    Long getProductId();

    String getProductName();

    int getProductPrice();

    int getProductSale();

    LocalDateTime getProductSaleStartDate();

    LocalDateTime getProductSaleEndDate();

    String getProductImgOriginName();

    String getProductImgSaveName();

    String getProductImgUrl();

    Long getProductStoreStoreId();

    String getProductStoreStoreName();

    Long getWishId();
}
