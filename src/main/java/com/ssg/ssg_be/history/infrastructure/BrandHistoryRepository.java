package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.BrandHistory;
import com.ssg.ssg_be.history.domain.BrandHistoryDtoRes;
import com.ssg.ssg_be.history.domain.ViewHistoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandHistoryRepository extends JpaRepository<BrandHistory, Long> {
    List<BrandHistoryDtoRes> findAllByUserUserId(Long userId);
}
