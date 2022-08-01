package com.ssg.ssg_be.signup.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
public class Marketing {

    @Id
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private int marketing1;
    private Timestamp updateAt1;

    private int marketing2;
    private Timestamp updateAt2;

    private int marketing3;
    private Timestamp updateAt3;
}
