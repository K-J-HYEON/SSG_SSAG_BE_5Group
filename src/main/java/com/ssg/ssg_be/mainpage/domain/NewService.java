package com.ssg.ssg_be.mainpage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class NewService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newServiceId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subTitle;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String saveName;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int priority;
}
