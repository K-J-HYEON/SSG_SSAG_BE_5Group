package com.ssg.ssg_be.category.infrastructure;

import com.ssg.ssg_be.category.domain.Category;
import com.ssg.ssg_be.category.domain.CategoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<CategoryDtoRes> findByNameContains(Long categoryId);
}
