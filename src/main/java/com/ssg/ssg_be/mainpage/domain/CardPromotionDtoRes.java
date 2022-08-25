package com.ssg.ssg_be.mainpage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CardPromotionDtoRes {

    private Long cardPromotionId;
    private String cardName;
    private String event;
    private String benefits;
    private String tagImgUrl;
}
