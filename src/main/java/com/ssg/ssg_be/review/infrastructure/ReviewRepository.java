package com.ssg.ssg_be.review.infrastructure;

import com.ssg.ssg_be.review.domain.Review;
import com.ssg.ssg_be.review.domain.ReviewDtoRes;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    boolean existsByProduct_ProductId(Long productId);

    @Query(value = "select count(*) as reviewCount, round(avg(score),1) as reviewAvg from review where product_id = ?1", nativeQuery = true)
    ReviewTotalDto retrieveReviewAvg(@Param("productId") Long productId);

    List<ReviewDtoRes> findByProductProductId(Long productId);
    List<ReviewDtoRes> findByUserUserId(Long userId);

}
