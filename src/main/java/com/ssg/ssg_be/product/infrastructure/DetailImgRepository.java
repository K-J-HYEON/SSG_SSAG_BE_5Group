package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.DetailImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailImgRepository extends JpaRepository<DetailImg, Long> {
    List<DetailImg> findByProductProductIdOrderByPriority(Long productId);
}
