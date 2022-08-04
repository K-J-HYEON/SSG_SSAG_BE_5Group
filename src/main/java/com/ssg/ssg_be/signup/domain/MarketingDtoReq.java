package com.ssg.ssg_be.signup.domain;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
public class MarketingDtoReq {


    private User user;

    private int marketing1;
    private Timestamp updateAt1;
    private int marketing2;
    private Timestamp updateAt2;
    private int marketing3;
    private Timestamp updateAt3;


    public Marketing toMarketingEntity() {
        return Marketing.builder()
                .user(user)
                .marketing1(marketing1)
                .updateAt1(updateAt1)
                .marketing2(marketing2)
                .updateAt2(updateAt2)
                .marketing3(marketing3)
                .updateAt3(updateAt3)
                .build();
    }
}
