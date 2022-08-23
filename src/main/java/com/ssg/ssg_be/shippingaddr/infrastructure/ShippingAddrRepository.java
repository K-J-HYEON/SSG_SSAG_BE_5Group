package com.ssg.ssg_be.shippingaddr.infrastructure;

import com.ssg.ssg_be.shippingaddr.domain.ShippingAddr;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddrRepository extends JpaRepository<ShippingAddr, Long> {
    List<ShippingAddrDtoRes> findAllByUserUserId(Long userId);
    ShippingAddrDtoRes findByUserUserIdAndAddrDefault(Long userId, int addrDefault);

    List<ShippingAddr> findByUserUserId(Long userId);
    boolean existsByUserUserId(Long userId);
}
