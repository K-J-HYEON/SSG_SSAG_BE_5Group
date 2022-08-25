package com.ssg.ssg_be.history.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BrandHistoryDtoReq {

    private Long productId;
    private Long storeId;
    private String storeName;

    public BrandHistory toEntity(User user) {
        return BrandHistory.builder()
                .storeId(storeId)
                .storeName(storeName)
                .user(user)
                .build();
    }
}
