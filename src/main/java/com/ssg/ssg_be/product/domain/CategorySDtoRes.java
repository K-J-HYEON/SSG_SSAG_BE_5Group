package com.ssg.ssg_be.product.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategorySDtoRes {
    private int categorySId;
    private int categoryMId;
    private String name;
}
