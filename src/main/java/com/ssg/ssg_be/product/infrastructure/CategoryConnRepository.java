package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.CategoryConn;
import com.ssg.ssg_be.product.domain.CategoryConnDtoRes;
import com.ssg.ssg_be.product.domain.CategorySDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryConnRepository extends JpaRepository<CategoryConn, Long> {
    List<CategoryConnDtoRes> findByNameContains(String searchWord);
}
