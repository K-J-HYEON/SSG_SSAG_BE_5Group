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
public class SearchHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchHistoryId;

    @Column(nullable = false)
    private String searchWord;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
