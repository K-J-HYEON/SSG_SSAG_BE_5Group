package com.ssg.ssg_be.review.infrastructure;

import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import com.ssg.ssg_be.review.domain.Review;
import com.ssg.ssg_be.review.domain.ReviewDtoRes;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    boolean existsByProduct_ProductId(Long productId);

    @Query(value = "select count(r) as reviewCount, avg(r.score) as reviewAvg from Review r where r.product.productId =:productId")
    ReviewTotalDto retrieveReviewAvg(@Param("productId") Long productId);

    List<ReviewDtoRes> findByProductProductId(Long productId);
    List<ReviewDtoRes> findByUserUserId(Long userId);



}
