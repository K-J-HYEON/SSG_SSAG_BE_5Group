package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.CategoryConn;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {

    Page<CategoryProductDtoRes> findAllBy(Pageable pageable);
    Page<CategoryProductDtoRes> findByMediumCategoryId(Long mediumCategoryId, Pageable pageable);
    Page<CategoryProductDtoRes> findBySmallCategorySmallCategoryId(Long smallCategoryId, Pageable pageable);
    Page<CategoryProductDtoRes> findByLargeCategoryId(Long largeCategoryId, Pageable pageable);
    Page<CategoryProductDtoRes> findByProductNameContains(String searchWord, Pageable pageable);

}
