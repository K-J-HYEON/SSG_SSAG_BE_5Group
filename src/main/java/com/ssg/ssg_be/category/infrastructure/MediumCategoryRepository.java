package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.MediumCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediumCategoryRepository extends JpaRepository<MediumCategory, Long> {
}
