package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}