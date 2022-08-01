package com.ssg.ssg_be.signup.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String loginPwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String corporation_number;

//    private Timestamp createAt;
//    private Timestamp updateAt;
}
