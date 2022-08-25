package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.CategoryHistory;
import com.ssg.ssg_be.history.domain.ViewHistoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryHistoryRepository extends JpaRepository<CategoryHistory, Long> {
//    List<> findAllByUserUserId(Long userId);
}
