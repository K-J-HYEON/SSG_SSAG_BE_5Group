package com.ssg.ssg_be.productInquiry.domain;

import com.ssg.ssg_be.BaseTimeEntity;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class ProductInquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long qnaId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    @Column(nullable = false)
//    private Product product;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int secret;

    @Column(nullable = false)
    private int answerStatus;


}
