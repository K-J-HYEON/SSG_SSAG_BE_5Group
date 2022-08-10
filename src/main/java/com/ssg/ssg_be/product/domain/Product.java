package com.ssg.ssg_be.product.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.store.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Getter
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int count;

    private int rate;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String size;

    private Timestamp expirationDate;

    private int sale;

    private Timestamp sale_start_date;

    private Timestamp sale_end_date;

}
