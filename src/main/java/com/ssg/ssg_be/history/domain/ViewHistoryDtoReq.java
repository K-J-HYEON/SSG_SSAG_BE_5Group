package com.ssg.ssg_be.history.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ViewHistoryDtoReq {

    private Long productId;
    private String name;
    private int price;
    private String productImg;

    public ViewHistory toEntity(Product product, User user) {
        return ViewHistory.builder()
                .name(name)
                .price(price)
                .user(user)
                .build();
    }
}
