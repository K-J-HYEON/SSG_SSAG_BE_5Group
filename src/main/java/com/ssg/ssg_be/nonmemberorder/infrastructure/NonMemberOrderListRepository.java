package com.ssg.ssg_be.nonmemberorder.infrastructure;

import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonMemberOrderListRepository extends JpaRepository<NonMemberOrderList, Long> {
}
