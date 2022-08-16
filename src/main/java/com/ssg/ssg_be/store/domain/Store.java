package com.ssg.ssg_be.store.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssg.config.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String grade;

    @JsonIgnore
    @Column(nullable = false)
    private int state;
}
