package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<ProductDtoRes> findByNameContains(Long productId);
}