package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DetailImgDtoRes {
    private Long detailImgId;
    private String originName;
    private String saveName;
    private String imgUrl;
    private int priority;
}
