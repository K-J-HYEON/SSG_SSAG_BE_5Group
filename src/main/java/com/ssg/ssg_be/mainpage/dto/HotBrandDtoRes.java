package com.ssg.ssg_be.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class HotBrandDtoRes {
    private Long hotBrandId;
    private String brandName;
    private String imgUrl;
    private int priority;
}
