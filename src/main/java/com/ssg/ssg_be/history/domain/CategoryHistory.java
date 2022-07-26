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

    public CategoryHistory dtoToCategoryHistoryEntity(Long categoryHistoryId,
                                                      Long categoryId,
                                                      String name,
                                                      int type,
                                                      User user) {
        return CategoryHistory.builder()
                .categoryHistoryId(categoryHistoryId)
                .categoryId(categoryId)
                .categoryName(name)
                .categoryType(type)
                .user(user)
                .build();
    }

    public CategoryHistory toCategoryHistoryEntity(CategoryHistory categoryHistory) {
        return CategoryHistory.builder()
                .categoryHistoryId(categoryHistory.getCategoryHistoryId())
                .categoryId(categoryHistory.getCategoryId())
                .categoryName(categoryHistory.getCategoryName())
                .categoryType(categoryHistory.getCategoryType())
                .user(categoryHistory.getUser())
                .build();
    }

}
