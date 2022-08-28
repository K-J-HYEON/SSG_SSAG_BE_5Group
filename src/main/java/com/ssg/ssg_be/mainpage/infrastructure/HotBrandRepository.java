package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.HotBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotBrandRepository extends JpaRepository<HotBrand, Long> {
    List<HotBrand> findAllByOrderByPriority();
}
