package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImgRepository extends JpaRepository<ProductImg, Long> {
    List<ProductImg> findByProductProductIdOrderByPriority(Long productId);
}
