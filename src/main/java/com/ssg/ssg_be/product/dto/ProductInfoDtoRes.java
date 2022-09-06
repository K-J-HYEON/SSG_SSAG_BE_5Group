package com.ssg.ssg_be.product.dto;

import com.ssg.ssg_be.review.dto.ReviewTotalDto;
import com.ssg.ssg_be.wish.dto.WishDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ProductInfoDtoRes {
    private Long productId;
    private String name;
    private int price;
    private int sale;
    private Long storeId;
    private String storeName;

    private ReviewTotalDto reviewTotal;
    private List<ProductImgDtoRes> productImg;
    private WishDto wishDto;
}
