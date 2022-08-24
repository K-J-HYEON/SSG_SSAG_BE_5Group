package com.ssg.ssg_be.mainpage.domain;

import com.ssg.config.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardPromotion extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardPromotionId;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String event;

    @Column(nullable = false)
    private String benefits;

    @Column(nullable = false)
    private String tagImgUrl;
}
