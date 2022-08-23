package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    List<ProductOption> findByProductProductId(Long productId);
}
