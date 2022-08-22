package com.ssg.ssg_be.order.infrastructure;

import com.ssg.ssg_be.order.domain.OrderDtoListRes;
import com.ssg.ssg_be.order.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    List<OrderDtoListRes> findAllByUserUserId(Long userId);
}
