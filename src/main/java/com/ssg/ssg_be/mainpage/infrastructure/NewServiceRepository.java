package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.NewService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewServiceRepository extends JpaRepository<NewService, Long> {
    List<NewService> findAllByOrderByPriority();
}
