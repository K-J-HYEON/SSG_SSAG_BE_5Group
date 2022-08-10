package com.ssg.ssg_be.category.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class CategoryM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryMId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;
}
