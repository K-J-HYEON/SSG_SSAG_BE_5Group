package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.MediumCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumCategoryRepository extends JpaRepository<MediumCategory, Long> {
}
