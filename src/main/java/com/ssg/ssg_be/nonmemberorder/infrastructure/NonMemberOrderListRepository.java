package com.ssg.ssg_be.nonmemberorder.infrastructure;

import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonMemberOrderListRepository extends JpaRepository<NonMemberOrderList, Long> {
}
