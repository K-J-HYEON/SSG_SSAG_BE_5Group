package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.CategoryConn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {
}
