package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImg, Long> {
    List<ProductImg> findByProductProductIdOrderByPriority(Long productId);
}
