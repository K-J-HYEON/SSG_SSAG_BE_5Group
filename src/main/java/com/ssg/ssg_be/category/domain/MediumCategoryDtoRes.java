package com.ssg.ssg_be.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class MediumCategoryDtoRes {
    private Long largeCategoryId;
    private String largeCategoryTitle;
    private List<MediumCategoryList> mediumCategoryList;

}
