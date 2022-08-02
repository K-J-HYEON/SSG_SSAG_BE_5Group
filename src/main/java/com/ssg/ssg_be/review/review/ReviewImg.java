package com.ssg.ssg_be.review.review;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ReviewImg{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImgId;

    @ManyToOne
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String saveName;

    @Column(nullable = false)
    private String path;
}
