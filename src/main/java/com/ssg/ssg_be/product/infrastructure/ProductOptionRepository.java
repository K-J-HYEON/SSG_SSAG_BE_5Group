package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    ProductOption findByProductProductIdAndColorColorIdAndSizeSizeId(Long productId, Long colorId, Long sizeId);
}
