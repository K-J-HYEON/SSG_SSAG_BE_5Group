package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.MediumCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediumCategoryRepository extends JpaRepository<MediumCategory, Long> {
    List<MediumCategory> findAllByLargeCategoryLargeCategoryId(Long largeCategoryId);
}
