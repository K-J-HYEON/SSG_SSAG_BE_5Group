package com.ssg.ssg_be.shippingaddr.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.shippingaddr.application.ShippingAddrService;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoReq;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrPutDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ShippingAddrController {

    private final ShippingAddrService shippingAddrService;

    @Autowired
    public ShippingAddrController(ShippingAddrService shippingAddrService) {
        this.shippingAddrService = shippingAddrService;
    }

    @PostMapping("/shipping-addr")
    public BaseResponse<String> createShippingAddr(@RequestBody ShippingAddrDtoReq shippingAddrDtoReq) {
        String result = "";

        try {
            shippingAddrService.createShippingAddr(shippingAddrDtoReq);
            result = "배송지 추가에 성공했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/shipping-addr/{userId}")
    public BaseResponse<List<ShippingAddrDtoRes>> retrieveShippingAddr(@PathVariable Long userId) {
        try {
            List<ShippingAddrDtoRes> shippingAddrDtoRes = shippingAddrService.retrieveShippingAddr(userId);
            return new BaseResponse<>(shippingAddrDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/shipping-addr/default/{userId}")
    public BaseResponse<ShippingAddrDtoRes> retrieveBasicShippingAddr(@PathVariable Long userId) {
        try {
            return new BaseResponse<>(shippingAddrService.retrieveBasicShippingAddr(userId));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/shipping-addr")
    public BaseResponse<String> updateShippingAddr(@RequestBody ShippingAddrPutDtoReq shippingAddrPutDtoReq) {
        String result = "";

        try {
            shippingAddrService.updateShippingAddr(shippingAddrPutDtoReq);
            result = "배송지 변경에 성공하였습니다.";
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
