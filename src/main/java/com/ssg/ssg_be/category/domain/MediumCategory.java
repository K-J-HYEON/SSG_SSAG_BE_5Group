package com.ssg.ssg_be.category.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class MediumCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediumCategoryId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private LargeCategory largeCategory;

    @Column(nullable = false)
    private String name;
}
