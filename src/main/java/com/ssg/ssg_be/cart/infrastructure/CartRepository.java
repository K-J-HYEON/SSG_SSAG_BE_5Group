package com.ssg.ssg_be.cart.infrastructure;

import com.ssg.ssg_be.cart.domain.Cart;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.store.domain.StoreIdDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<CartDtoRes> findByUserUserId(Long userId);

    @Query(value = "select c from Cart as c where c.user.userId =:userId and c.productOption.product.store.storeId =:storeId")
    List<Cart> getCartsByStore(@Param("userId") Long userId, @Param("storeId") Long storeId);

    List<StoreIdDto> findAllByUserUserId(Long userId);

    boolean existsByUserUserIdAndProductOption_ProductOptionId(Long userId, Long productOptionId);

    Cart findByUserUserIdAndProductOption_ProductOptionId(Long userId, Long productOptionId);
}
