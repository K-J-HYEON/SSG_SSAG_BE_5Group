package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.CategoryHistory;
import com.ssg.ssg_be.history.dto.CategoryHistoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryHistoryRepository extends JpaRepository<CategoryHistory, Long> {
    List<CategoryHistoryDtoRes> findAllByUserUserId(Long userId);

    boolean existsByUserUserIdAndCategoryTypeAndCategoryId(Long userId, int categoryType, Long categoryId);

    CategoryHistory findByUserUserIdAndCategoryTypeAndCategoryId(Long userId, int categoryType, Long categoryId);
}
