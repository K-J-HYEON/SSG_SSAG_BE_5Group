package com.ssg.ssg_be.paymentmethod.infrastucture;

import com.ssg.ssg_be.paymentmethod.domain.PaymentMethod;
import com.ssg.ssg_be.paymentmethod.domain.PaymentMethodDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    List<PaymentMethodDtoRes> findByUserUserId(Long userId);
}
