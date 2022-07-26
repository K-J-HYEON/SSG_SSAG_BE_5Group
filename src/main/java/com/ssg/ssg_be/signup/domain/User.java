package com.ssg.ssg_be.signup.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssg.config.BaseTimeEntity;
import com.ssg.config.Role;
import com.ssg.ssg_be.memberInfo.dto.MemberInfoDtoRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String loginId;

    private String loginPwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String phone;

    // 0: Friends 등급, 1: Gold 등급, 2: VIP 등급
    @Column(columnDefinition = "tinyint(1) default 0")
    private int grade;  // 회원 등급

    // 0: 통합회원, 1: 카카오 간편가입, 2: 네이버 간편가입
    @Column(columnDefinition = "tinyint(1) default 0")
    private int userType;   // 회원 유형

    private Timestamp loginDate;

    //0: 활동 중인 사용자(일반 상태), 1: N개월 이상 미접속 사용자, 2: 정지된 사용자
    @Column(columnDefinition = "tinyint(1) default 0")
    private int status; // 회원 상태

    @Enumerated(EnumType.STRING)
    private Role userRole;

    public MemberInfoDtoRes toDto() {
        return MemberInfoDtoRes.builder()
                .userId(userId)
                .loginId(loginId)
                .name(name)
                .phone(phone)
                .email(email)
                .build();
    }

    public User updateLoginDate() {
        loginDate = Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return this;
    }
}
