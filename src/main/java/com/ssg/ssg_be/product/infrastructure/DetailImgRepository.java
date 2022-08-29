package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.DetailImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailImgRepository extends JpaRepository<DetailImg, Long> {
    List<DetailImg> findByProductProductIdOrderByPriority(Long productId);
}
