package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Long> {
    List<SmallCategory> findAllByMediumCategoryMediumCategoryId(Long mediumCategoryId);
}
