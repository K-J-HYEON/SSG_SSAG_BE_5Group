package com.ssg.ssg_be.cart.infrastructure;

import com.ssg.ssg_be.cart.domain.Cart;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.signup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<CartDtoRes> findByUser(User user);
}
