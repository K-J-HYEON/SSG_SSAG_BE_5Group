package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductImgDtoRes {
    private Long productImgId;
    private String originName;
    private String saveName;
    private String imgUrl;
    private int priority;
}
