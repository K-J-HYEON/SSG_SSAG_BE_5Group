package com.ssg.ssg_be.viewhistory.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ViewHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewHistoryId;

    @Column(nullable = false)
    private int productid;

    // user 엔티티 넣어서 반영
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;



}
