package com.ssg.ssg_be.mainpage.infrastructure;

import com.ssg.ssg_be.mainpage.domain.NewService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewServiceRepository extends JpaRepository<NewService, Long> {
    List<NewService> findAllByOrderByPriority();
}
