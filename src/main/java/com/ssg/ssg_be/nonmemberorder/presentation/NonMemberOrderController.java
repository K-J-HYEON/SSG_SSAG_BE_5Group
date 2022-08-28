package com.ssg.ssg_be.nonmemberorder.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.nonmemberorder.application.NonMemberOrderService;
import com.ssg.ssg_be.nonmemberorder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ssg.config.BaseResponseStatus.NO_LOOKUP_VALUE;

@RestController
@RequestMapping("/non-users")
public class NonMemberOrderController {

    private final NonMemberOrderService nonMemberOrderService;

    @Autowired
    public NonMemberOrderController(NonMemberOrderService nonMemberOrderService) {
        this.nonMemberOrderService = nonMemberOrderService;
    }

    @PostMapping("/order")
    public BaseResponse<NonMemberOrderIdDtoRes> createNonMemberOrders(@RequestBody NonMemberOrderListDtoReq nonMemberOrderListDtoReq) {

        try {
            NonMemberOrderIdDtoRes nonMemberOrderIdDtoRes = nonMemberOrderService.createNonMemberOrders(nonMemberOrderListDtoReq);
            return new BaseResponse<>(nonMemberOrderIdDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PostMapping("/order/auth")
    public BaseResponse<String> authNonMember(@RequestBody NonMemberAuthDtoReq nonMemberAuthDtoReq) throws BaseException {
        String result = "";

        if (nonMemberOrderService.authNonMember(nonMemberAuthDtoReq)) {
            result = "비회원 인증 성공";
        } else {
            throw new BaseException(NO_LOOKUP_VALUE);
        }
        return new BaseResponse<>(result);
    }

    @GetMapping("/order/check/{orderListId}")
    public BaseResponse<NonMemberOrderListDtoRes> retrieveNonMemberOrders(@PathVariable Long orderListId) {

        try {
            NonMemberOrderListDtoRes nonMemberOrderListDtoRes = nonMemberOrderService.retrieveNonMemberOrders(orderListId);
            return new BaseResponse<>(nonMemberOrderListDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/cancel/{orderId}")
    public BaseResponse<String> cancelNonMemberOrder(@PathVariable Long orderId) {
        String result = "";
        try {
            nonMemberOrderService.cancelNonMemberOrder(orderId);
            result = "취소 처리 되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/return/{orderId}")
    public BaseResponse<String> returnNonMemberOrder(@PathVariable Long orderId) {
        String result = "";
        try {
            nonMemberOrderService.updateNonMemberOrder(orderId, 2);
            result = "반품 신청되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/exchange/{orderId}")
    public BaseResponse<String> exchangeNonMemberOrder(@PathVariable Long orderId) {
        String result = "";
        try {
            nonMemberOrderService.updateNonMemberOrder(orderId, 3);
            result = "교환 신청되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
