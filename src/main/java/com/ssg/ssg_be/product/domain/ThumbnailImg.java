package com.ssg.ssg_be.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ThumbnailImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thumbnailImgId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String saveName;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int priority;
}
