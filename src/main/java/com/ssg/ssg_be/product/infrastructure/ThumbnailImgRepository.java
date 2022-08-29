package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ThumbnailImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThumbnailImgRepository extends JpaRepository<ThumbnailImg, Long> {
    List<ThumbnailImg> findAllByProductProductIdOrderByPriority(Long productId);
}
