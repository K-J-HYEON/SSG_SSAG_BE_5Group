package com.ssg.ssg_be.signup.infrastucture;

import com.ssg.ssg_be.signup.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);
    boolean existsByCorporationNumber(String corporationNumber);
    boolean existsByPhone(String phone);

    Optional<Seller> findByLoginId(String loginId);
}
