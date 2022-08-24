package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.HappyLounge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HappyLoungeRepository extends JpaRepository<HappyLounge, Long> {
}
