package com.ssg.ssg_be.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class CategoryDtoRes {

    private Long largeCategoryId;
    private String title;

    private List<MediumCategoryList> mediumCategoryList;
}
