package com.ssg.ssg_be.shippingaddr.infrastructure;

import com.ssg.ssg_be.shippingaddr.domain.ShippingAddr;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import com.ssg.ssg_be.signup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddrRepository extends JpaRepository<ShippingAddr, Long> {
    List<ShippingAddrDtoRes> findByUserUserId(Long userId);
}
