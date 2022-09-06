package com.ssg.ssg_be.shippingaddr.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.shippingaddr.application.ShippingAddrService;
import com.ssg.ssg_be.shippingaddr.dto.ShippingAddrDefaultPutDtoReq;
import com.ssg.ssg_be.shippingaddr.dto.ShippingAddrDtoReq;
import com.ssg.ssg_be.shippingaddr.dto.ShippingAddrDtoRes;
import com.ssg.ssg_be.shippingaddr.dto.ShippingAddrPutDtoReq;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ShippingAddrController {

    private final ShippingAddrService shippingAddrService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ShippingAddrController(ShippingAddrService shippingAddrService, JwtTokenProvider jwtTokenProvider) {
        this.shippingAddrService = shippingAddrService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/shipping-addr")
    public BaseResponse<String> createShippingAddr(@RequestBody ShippingAddrDtoReq shippingAddrDtoReq) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));
        String result = "";

        try {
            shippingAddrService.createShippingAddr(shippingAddrDtoReq, userId);
            result = "배송지 추가에 성공했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/shipping-addr")
    public BaseResponse<List<ShippingAddrDtoRes>> retrieveShippingAddr() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ShippingAddrDtoRes> shippingAddrDtoRes = shippingAddrService.retrieveShippingAddr(userId);
            return new BaseResponse<>(shippingAddrDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/shipping-addr/{addrId}")
    public BaseResponse<ShippingAddrDtoRes> retrieveOneShippingAddr(@PathVariable Long addrId) {

        try {
            ShippingAddrDtoRes shippingAddrDtoRes = shippingAddrService.retrieveOneShippingAddr(addrId);
            return new BaseResponse<>(shippingAddrDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/shipping-addr/default")
    public BaseResponse<ShippingAddrDtoRes> retrieveBasicShippingAddr() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            return new BaseResponse<>(shippingAddrService.retrieveBasicShippingAddr(userId));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/shipping-addr")
    public BaseResponse<String> updateShippingAddr(@RequestBody ShippingAddrPutDtoReq shippingAddrPutDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            shippingAddrService.updateShippingAddr(shippingAddrPutDtoReq, userId);
            result = "배송지 변경에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/shipping-addr/default")
    public BaseResponse<String> updateDefaultShippingAddr(@RequestBody ShippingAddrDefaultPutDtoReq shippingAddrDefaultPutDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            shippingAddrService.updateDefaultShippingAddr(shippingAddrDefaultPutDtoReq, userId);
            result = "기본 배송지 변경에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/shipping-addr/{addrId}")
    private BaseResponse<String> deleteShippingAddr(@PathVariable Long addrId) {
        String result = "";
        try {
            shippingAddrService.deleteShippingAddr(addrId);
            result = "배송지를 삭제하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
