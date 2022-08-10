package com.ssg.ssg_be.category.infrastructure;
import com.ssg.ssg_be.category.domain.SmallCategory;
import com.ssg.ssg_be.category.domain.SmallCategoryIdDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Long> {

}
