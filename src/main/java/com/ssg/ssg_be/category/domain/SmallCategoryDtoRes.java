package com.ssg.ssg_be.category.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class SmallCategoryDtoRes {
    private Long mediumCategoryId;
    private String mediumCategoryTitle;
    private List<SmallCategoryList> smallCategoryList;
}
