package com.ssg.ssg_be.nonmemberorder.infrastructure;

import com.ssg.ssg_be.nonmemberorder.domain.NonMemberOrder;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonMemberOrderRepository extends JpaRepository<NonMemberOrder, Long> {
    boolean existsByNonMemberOrderList_NonMemberOrderListIdAndNonMemberOrderList_NameAndNonMemberOrderList_Phone(Long nonMemberOrderListId, String name, String phone);

    List<NonMemberOrderDtoRes> findAllByNonMemberOrderList_NonMemberOrderListId(Long nonMemberOrderListIde);
}
