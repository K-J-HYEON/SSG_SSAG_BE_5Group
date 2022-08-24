package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.HotBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotBrandRepository extends JpaRepository<HotBrand, Long> {
    List<HotBrand> findAllByOrderByPriority();
}
