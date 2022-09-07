package com.ssg.ssg_be.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class MediumCategoryList {

    private Long mediumCategoryId;
    private String mediumCategoryTitle;
}
