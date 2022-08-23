package com.ssg.ssg_be.shippingaddr.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDefaultPutDtoReq;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoReq;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrPutDtoReq;

import java.util.List;

public interface ShippingAddrService {

    void createShippingAddr(ShippingAddrDtoReq shippingAddrDtoReq, Long userId) throws BaseException;
    List<ShippingAddrDtoRes> retrieveShippingAddr(Long userId) throws BaseException;
    ShippingAddrDtoRes retrieveOneShippingAddr(Long addrId) throws BaseException;
    ShippingAddrDtoRes retrieveBasicShippingAddr(Long userId) throws BaseException;
    void updateShippingAddr(ShippingAddrPutDtoReq shippingAddrPutDtoReq, Long userId) throws BaseException;
    void updateDefaultShippingAddr(ShippingAddrDefaultPutDtoReq shippingAddrDefaultPutDtoReq, Long userId) throws BaseException;
    void deleteShippingAddr(Long addrId) throws BaseException;

}
