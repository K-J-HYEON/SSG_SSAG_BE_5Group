package com.ssg.ssg_be.product.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class CategoryS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorySId;

    @ManyToOne
    @JoinColumn(name = "categoryMId", nullable = false)
    private CategoryM categoryM;

    @Column(nullable = false)
    private String name;
}
