package com.ssg.ssg_be.order.infrastructure;

import com.ssg.ssg_be.order.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}
