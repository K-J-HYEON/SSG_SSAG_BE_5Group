package com.ssg.ssg_be.wish.infrastructure;

import com.ssg.ssg_be.wish.domain.Wish;
import com.ssg.ssg_be.wish.dto.WishDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
    List<WishDtoRes> findByUserUserIdOrderByCreateAtDesc(Long userId);

    Wish findByUserUserIdAndProductProductId(Long userId, Long productId);

    List<Wish> findByUserUserIdAndProductProductIdIn(Long userId, List<Long> productIds);

    boolean existsByProductProductIdAndUserUserId(Long productId, Long userId);

}
