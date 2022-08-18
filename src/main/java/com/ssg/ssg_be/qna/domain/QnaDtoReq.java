package com.ssg.ssg_be.qna.domain;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class QnaDtoReq {

    private Long productId;
    private Long userId;
    private int type;
    private String title;
    private String content;
    private int secret;

    public Qna toEntity(Product product, User user) {
        return Qna.builder()
                .product(product)
                .user(user)
                .type(type)
                .title(title)
                .content(content)
                .secret(secret)
                .build();
    }
}
