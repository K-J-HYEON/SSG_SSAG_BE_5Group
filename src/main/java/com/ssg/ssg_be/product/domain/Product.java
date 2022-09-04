package com.ssg.ssg_be.product.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.store.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private int sale;

    private Timestamp saleStartDate;

    private Timestamp saleEndDate;

    private String imgOriginName;

    private String imgSaveName;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;
}
