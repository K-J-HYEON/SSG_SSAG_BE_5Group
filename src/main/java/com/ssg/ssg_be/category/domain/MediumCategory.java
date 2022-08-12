package com.ssg.ssg_be.category.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MediumCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediumCategoryId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private LargeCategory largeCategory;

    @Column(nullable = false)
    private String mediumCategoryTitle;
}
