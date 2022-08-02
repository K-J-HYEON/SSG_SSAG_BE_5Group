package com.ssg.ssg_be.signup.infrastucture;

import com.ssg.ssg_be.signup.domain.Marketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingRepository extends JpaRepository<Marketing, Long> {
}
