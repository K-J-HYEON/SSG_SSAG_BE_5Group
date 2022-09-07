package com.ssg.ssg_be.product.dto;

import java.sql.Timestamp;

public interface CategoryProductDtoRes {
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
