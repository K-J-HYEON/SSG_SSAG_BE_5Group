package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.CategoryConn;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {

    Slice<CategoryProductDtoRes> findAllBy(Pageable pageable);
    Slice<CategoryProductDtoRes> findByMediumCategoryId(Long mediumCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findBySmallCategorySmallCategoryId(Long smallCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByLargeCategoryId(Long largeCategoryId, Pageable pageable);
    Slice<CategoryProductDtoRes> findByProductNameContaining(String searchWord, Pageable pageable);

}
