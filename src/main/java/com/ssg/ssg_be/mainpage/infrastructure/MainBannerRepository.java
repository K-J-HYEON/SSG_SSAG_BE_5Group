package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.MainBanner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainBannerRepository extends JpaRepository<MainBanner, Long> {
    List<MainBanner> findAllByOrderByPriority();
}
