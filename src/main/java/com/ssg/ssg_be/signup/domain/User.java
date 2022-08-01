package com.ssg.ssg_be.signup.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssg.ssg_be.order.domain.Order;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String loginPwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    // 0: Friends 등급, 1: Gold 등급, 2: VIP 등급
    @Column(columnDefinition = "tinyint() default 0")
    private int grade;  // 회원 등급

    // 0: 통합회원, 1: 카카오 간편가입, 2: 네이버 간편가입
    @Column(columnDefinition = "tinyint() default 0")
    private int userType;   // 회원 유형

//    private Timestamp createAt;
//    private Timestamp updateAt;

    private Timestamp loginDate;

    //0: 활동 중인 사용자(일반 상태), 1: N개월 이상 미접속 사용자, 2: 정지된 사용자
    @Column(columnDefinition = "tinyint() default 0")
    private int status; // 회원 상태

}
