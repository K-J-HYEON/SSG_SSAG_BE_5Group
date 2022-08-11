package com.ssg.ssg_be.category.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class SmallCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long smallCategoryId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MediumCategory mediumCategory;

    @Column(nullable = false)
    private String name;
}
