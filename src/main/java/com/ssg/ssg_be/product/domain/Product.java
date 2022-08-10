package com.ssg.ssg_be.product.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.store.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String productNumber;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int deliveryFee;

    private String color;

    private String size;

    private Timestamp expirationDate;

    private int sale;

    private Timestamp saleStartDate;

    private Timestamp saleEndDate;

    @Column(nullable = false)
    private String imgOriginName;

    @Column(nullable = false)
    private String imgSaveName;

    @Column(nullable = false)
    private String imgPath;

}
