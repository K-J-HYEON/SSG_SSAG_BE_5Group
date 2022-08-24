package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.ThumbnailImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThumbnailImgRepository extends JpaRepository<ThumbnailImg, Long> {
    List<ThumbnailImg> findAllByProductProductId(Long productId);
}
