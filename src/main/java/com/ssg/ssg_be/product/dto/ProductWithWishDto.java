package com.ssg.ssg_be.product.dto;

import java.sql.Timestamp;

public interface ProductWithWishDto {
    Long getProductId();
    String getName();
    Integer getPrice();
    Integer getSale();
    Timestamp getSaleStartDate();
    Timestamp getSaleEndDate();
    String getImgOriginName();
    String getImgSaveName();
    String getImgUrl();
    Long getStoreId();
    String getStoreName();
    Integer getReviewCount();
    Double getReviewAvg();
    Long getWishId();
}
