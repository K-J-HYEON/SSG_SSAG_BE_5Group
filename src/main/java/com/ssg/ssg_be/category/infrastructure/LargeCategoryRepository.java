package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.LargeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LargeCategoryRepository extends JpaRepository<LargeCategory, Long> {
}
