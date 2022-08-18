package com.ssg.ssg_be.wish.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.wish.domain.WishDtoReq;
import com.ssg.ssg_be.wish.domain.WishDtoRes;

import java.util.List;

public interface WishServive {
    void createWish(WishDtoReq wishDtoReq, Long userId) throws BaseException;
    List<WishDtoRes> retrieveWish(Long userId) throws BaseException;
    void deleteWish(Long wishId) throws BaseException;
}
