package com.ssg.ssg_be.qna.dto;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.qna.domain.Qna;
import com.ssg.ssg_be.signup.domain.User;
import lombok.Getter;

@Getter
public class QnaPatchDtoReq {

    private Long qnaId;
    private Long productId;

    private int type;
    private String title;
    private String content;

    public Qna toEntity(Product product, User user) {
        return Qna.builder()
                .product(product)
                .user(user)
                .type(type)
                .title(title)
                .content(content)
                .build();
    }
}
