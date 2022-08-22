package com.ssg.ssg_be.review.infrastructure;

import com.ssg.ssg_be.review.domain.Review;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    boolean existsByProduct_ProductId(Long productId);

    @Query(value = "select count(r) as reviewCount, avg(r.score) as reviewAvg from Review r where r.product.productId =:productId")
    ReviewTotalDto retrieveReviewAvg(@Param("productId") Long productId);

    @Query(value = "select count(*) as reviewCount, round(avg(score),1) as reviewAvg from Review where product_id = ?1", nativeQuery = true)
    ReviewTotalDto test(@Param("productId") Long productId);
}
