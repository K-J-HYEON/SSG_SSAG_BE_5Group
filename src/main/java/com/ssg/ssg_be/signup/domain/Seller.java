package com.ssg.ssg_be.signup.domain;

import com.ssg.config.BaseTimeEntity;
import com.ssg.config.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String loginPwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String corporationName; // 법인명

    @Column(nullable = false, unique = true)
    private String corporationNumber;   // 법인 사업자등록번호

    @Column(nullable = false, unique = true)
    private String phone;

}
