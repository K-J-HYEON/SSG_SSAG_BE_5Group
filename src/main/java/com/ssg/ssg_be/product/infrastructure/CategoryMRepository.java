package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.CategoryDtoRes;
import com.ssg.ssg_be.product.domain.CategoryM;
import com.ssg.ssg_be.product.domain.CategoryMDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMRepository extends JpaRepository<CategoryM, Long> {
    List<CategoryMDtoRes> findByNameContains(Long categoryMId);
}
