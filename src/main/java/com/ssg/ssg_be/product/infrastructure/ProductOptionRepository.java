package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ProductColorDtoRes;
import com.ssg.ssg_be.product.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    @Query(value = "select distinct p.color.colorId as colorId, p.color.color as color from ProductOption p where p.product.productId =:productId")
    List<ProductColorDtoRes> getColorIds(@Param("productId") Long productId);

    List<ProductOption> findAllByProductProductIdAndColorColorId(Long productId, Long colorId);
}
