package com.ssg.ssg_be.product.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryMDtoRes {
    private int categoryId;
    private String name;
}
