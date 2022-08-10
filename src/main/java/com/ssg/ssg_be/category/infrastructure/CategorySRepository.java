package com.ssg.ssg_be.category.infrastructure;
import com.ssg.ssg_be.category.domain.CategoryS;
import com.ssg.ssg_be.category.domain.CategorySDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorySRepository extends JpaRepository<CategoryS, Long> {
    List<CategorySDtoRes> findByNameContains(Long categorySId);
}
