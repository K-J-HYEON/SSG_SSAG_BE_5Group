package com.ssg.ssg_be.shippingaddr.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoReq;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrPutDtoReq;

import java.util.List;

public interface ShippingAddrService {

    void createShippingAddr(ShippingAddrDtoReq shippingAddrDtoReq) throws BaseException;
    List<ShippingAddrDtoRes> retrieveShippingAddr(Long userId) throws BaseException;
    ShippingAddrDtoRes retrieveBasicShippingAddr(Long userId) throws BaseException;
    void updateShippingAddr(ShippingAddrPutDtoReq shippingAddrPutDtoReq) throws BaseException;
    void deleteShippingAddr(Long addrId) throws BaseException;

}
