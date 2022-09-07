package com.ssg.ssg_be.signup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marketing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketingId;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int marketing1;
    private Timestamp updateAt1;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int marketing2;
    private Timestamp updateAt2;

    @Column(columnDefinition = "tinyint(1) default 0")
    private int marketing3;
    private Timestamp updateAt3;
}
