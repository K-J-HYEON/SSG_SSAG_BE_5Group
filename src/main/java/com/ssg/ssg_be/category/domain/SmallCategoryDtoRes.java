package com.ssg.ssg_be.category.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SmallCategoryDtoRes {
    private Long smallCategoryId;
    private String smallCategoryTitle;
}
