package com.ssg.ssg_be.mainpage.domain;

import com.ssg.config.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class HotBrand extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotBrandId;

    @Column(nullable = false)
    private String brandName;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int priority;
}
