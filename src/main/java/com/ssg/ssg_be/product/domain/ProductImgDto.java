package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductImgDto {
    private int reviewId;
    private String originName;
    private String saveName;
    private String path;
}
