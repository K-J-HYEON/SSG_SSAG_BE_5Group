package com.ssg.ssg_be.paymentmethod.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long cardImgId;

    @Column(nullable = false)
    private String cardCompany;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String saveName;

    @Column(nullable = false)
    private String imgUrl;
}
