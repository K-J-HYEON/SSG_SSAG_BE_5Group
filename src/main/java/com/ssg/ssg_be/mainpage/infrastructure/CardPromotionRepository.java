package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.CardPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardPromotionRepository extends JpaRepository<CardPromotion, Long> {
}
