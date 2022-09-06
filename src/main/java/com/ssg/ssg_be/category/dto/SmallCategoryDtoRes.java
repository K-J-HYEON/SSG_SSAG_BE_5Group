package com.ssg.ssg_be.category.dto;

import com.ssg.ssg_be.category.domain.SmallCategoryList;
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
