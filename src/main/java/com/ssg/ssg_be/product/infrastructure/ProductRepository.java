package com.ssg.ssg_be.product.infrastructure;

import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.Marketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
