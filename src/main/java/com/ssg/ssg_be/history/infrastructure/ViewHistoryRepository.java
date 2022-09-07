package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.ViewHistory;
import com.ssg.ssg_be.history.dto.ViewHistoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewHistoryRepository extends JpaRepository<ViewHistory, Long> {
    List<ViewHistoryDtoRes> findAllByUserUserId(Long userId);

    boolean existsByUserUserIdAndProductId(Long userId, Long productId);

    ViewHistory findByUserUserIdAndProductId(Long userId, Long productId);
}