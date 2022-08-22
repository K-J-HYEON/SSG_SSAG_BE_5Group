package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    ProductOption findByProductProductIdAndColorColorIdAndSizeSizeId(Long productId, Long colorId, Long sizeId);
    List<ProductOption> findByProductProductId(Long productId);
}
