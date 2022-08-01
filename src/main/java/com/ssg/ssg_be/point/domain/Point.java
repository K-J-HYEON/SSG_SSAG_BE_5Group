package com.ssg.ssg_be.point.domain;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long pointId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private String content;

}
