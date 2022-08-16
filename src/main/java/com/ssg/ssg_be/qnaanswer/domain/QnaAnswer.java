package com.ssg.ssg_be.qnaanswer.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.qna.domain.Qna;

import javax.persistence.*;


public class QnaAnswer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaAnswerId;

    @OneToOne
    @JoinColumn(name = "qnaId", nullable = false)
    private Qna qna;

    @Column(nullable = false)
    private String text;

}
