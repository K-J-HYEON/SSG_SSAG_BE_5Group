package com.ssg.ssg_be.order.infrastructure;

import com.ssg.ssg_be.order.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
