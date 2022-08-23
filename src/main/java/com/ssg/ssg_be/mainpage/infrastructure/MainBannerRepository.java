package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.MainBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainBannerRepository extends JpaRepository<MainBanner, Long> {
    List<MainBanner> findAllByOrderByPriority();
}
