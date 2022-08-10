package com.ssg.ssg_be.category.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class LargeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long largeCategoryId;

    @Column(nullable = false)
    private String name;
}
