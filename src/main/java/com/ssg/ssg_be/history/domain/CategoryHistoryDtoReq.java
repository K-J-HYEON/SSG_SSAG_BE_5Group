package com.ssg.ssg_be.history.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryHistoryDtoReq {

    private Long productId;
    private Long categoryId;
    private String categoryName;
    private int categoryType;

    public CategoryHistory toEntity(User user) {
        return CategoryHistory.builder()
                .categoryId(categoryId)
                .categoryName(categoryName)
                .categoryType(categoryType)
                .user(user)
                .build();
    }
}
