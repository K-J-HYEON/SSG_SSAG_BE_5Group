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
public class CategoryHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryHistoryId;

    @Column(nullable = false)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private int categoryType; // 0 large / 1 medium / 2 small

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
