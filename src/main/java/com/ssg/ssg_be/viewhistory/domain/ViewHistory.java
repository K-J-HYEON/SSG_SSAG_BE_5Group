package com.ssg.ssg_be.viewhistory.domain;

import org.apache.catalina.User;

import javax.persistence.*;

public class ViewHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewHistoryId;

    @Column(nullable = false)
    private int productid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User user;



}
