package com.ssg.ssg_be.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryMDtoReq {
    private int categoryId;
    private String name;
}
