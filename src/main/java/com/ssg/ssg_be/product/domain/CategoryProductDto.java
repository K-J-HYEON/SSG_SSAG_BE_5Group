package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryProductDto {
    private Long productProductId;
    private String productName;
    private int productPrice;
    private int productSale;
    private Timestamp productSaleStartDate;
    private Timestamp productSaleEndDate;
    private String productImgOriginName;
    private String productImgSaveName;
    private String productImgUrl;
    private Long productStoreStoreId;
    private String productStoreName;

    public CategoryProductDto toDto(ProductWithWishDto product) {
        return CategoryProductDto.builder()
                .productProductId(product.getProductId())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .productSale(product.getSale())
                .productSaleStartDate(product.getSaleStartDate())
                .productSaleEndDate(product.getSaleEndDate())
                .productImgOriginName(product.getImgOriginName())
                .productImgSaveName(product.getImgSaveName())
                .productImgUrl(product.getImgUrl())
                .productStoreStoreId(product.getStoreId())
                .productStoreName(product.getStoreName())
                .build();
    }
}
