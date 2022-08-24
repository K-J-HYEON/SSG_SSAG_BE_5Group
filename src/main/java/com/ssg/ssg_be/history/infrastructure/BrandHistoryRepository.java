package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.BrandHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandHistoryRepository extends JpaRepository<BrandHistory, Long> {

}
