package com.ssg.ssg_be.nonmemberorder.infrastructure;

import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrder;
import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrderDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonMemberOrderRepository extends JpaRepository<NonMemberOrder, Long> {
    boolean existsByNonMemberOrderList_NonMemberOrderListIdAndNonMemberOrderList_NameAndNonMemberOrderList_Phone(Long nonMemberOrderListId, String name, String phone);
    List<NonMemberOrderDtoRes> findAllByNonMemberOrderList_NonMemberOrderListId(Long nonMemberOrderListIde);
}
