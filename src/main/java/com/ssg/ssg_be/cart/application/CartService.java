package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.dto.*;

public interface CartService {
    boolean createCart(CartDtoReq cartDtoReq, Long userId) throws BaseException;

    CartTotalDtoRes retrieveCart(Long userId) throws BaseException;

    void deleteCart(Long cartId) throws BaseException;

    void updateCartCount(CartCountPatchDtoReq cartCountPatchDtoReq) throws BaseException;

    CartOptionPatchDtoRes updateCartOption(CartOptionPatchDtoReq cartOptionPatchDtoReq, Long userId) throws BaseException;

    CartCountDto retrieveCartCount(Long userId) throws BaseException;
}
