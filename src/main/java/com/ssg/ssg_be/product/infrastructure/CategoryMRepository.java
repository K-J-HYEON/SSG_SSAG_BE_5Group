package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.CategoryM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMRepository extends JpaRepository<CategoryM, Long> {
}
