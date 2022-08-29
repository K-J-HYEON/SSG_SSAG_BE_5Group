package com.ssg.ssg_be.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class SmallCategoryList {
    private Long smallCategoryId;
    private String smallCategoryTitle;
}
