package com.ssg.ssg_be.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@Builder
public class Store {

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
