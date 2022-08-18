package com.ssg.ssg_be.paymentmethod.infrastucture;

import com.ssg.ssg_be.paymentmethod.domain.CardImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardImgRepository extends JpaRepository<CardImg, Long> {
    CardImg findByCardCompany(String cardCompany);
}
