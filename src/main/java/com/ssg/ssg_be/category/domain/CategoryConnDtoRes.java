package com.ssg.ssg_be.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class CategoryConnDtoRes {
    private int productId;
    private int categoryS;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
