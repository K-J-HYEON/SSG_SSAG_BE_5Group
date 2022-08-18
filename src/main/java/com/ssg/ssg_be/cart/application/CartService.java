package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.*;

import java.util.List;

public interface CartService {
    boolean createCart(CartDtoReq cartDtoReq, Long userId) throws BaseException;
    List<CartDtoRes> retrieveCart(Long userId) throws BaseException;
    void deleteCart(Long cartId) throws BaseException;
    void updateCartCount(CartCountPatchDtoReq cartCountPatchDtoReq) throws BaseException;
    CartOptionPatchDtoRes updateCartOption(CartOptionPatchDtoReq cartOptionPatchDtoReq, Long userId) throws BaseException;
}
