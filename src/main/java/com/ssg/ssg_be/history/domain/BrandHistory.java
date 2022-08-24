package com.ssg.ssg_be.history.domain;


import com.ssg.config.BaseTimeEntity;
import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BrandHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandHistoryId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

    // user 엔티티 넣어서 반영
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
