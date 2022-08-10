package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.CartDtoReq;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.cart.domain.CartPatchDtoReq;

import java.util.List;

public interface CartService {
    void createCart(CartDtoReq cartDtoReq) throws BaseException;
    List<CartDtoRes> retrieveCart(Long userId) throws BaseException;
    void deleteCart(Long cartId) throws BaseException;
    void updateCart(CartPatchDtoReq cartPatchDtoReq) throws BaseException;
}
