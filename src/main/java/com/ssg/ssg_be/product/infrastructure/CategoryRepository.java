package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
