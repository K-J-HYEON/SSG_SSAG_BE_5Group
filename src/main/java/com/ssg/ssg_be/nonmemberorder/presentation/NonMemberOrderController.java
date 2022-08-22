package com.ssg.ssg_be.nonmemberorder.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.nonmemberorder.application.NonMemberOrderService;
import com.ssg.ssg_be.nonmemberorder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/non-users")
public class NonMemberOrderController {

    private final NonMemberOrderService nonMemberOrderService;

    @Autowired
    public NonMemberOrderController(NonMemberOrderService nonMemberOrderService) {
        this.nonMemberOrderService = nonMemberOrderService;
    }

    //TODO #1 : 비회원 주문하기 => 주문 번호 반환하기
    @ResponseBody
    @PostMapping("/order")
    public BaseResponse<NonMemberOrderIdDtoRes> createNonMemberOrders(@RequestBody NonMemberOrderListDtoReq nonMemberOrderListDtoReq) {

        try {
            NonMemberOrderIdDtoRes nonMemberOrderIdDtoRes = nonMemberOrderService.createNonMemberOrders(nonMemberOrderListDtoReq);
            return new BaseResponse<>(nonMemberOrderIdDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/order/check")
    public BaseResponse<NonMemberOrderListDtoRes> retrieveNonMemberOrders(@RequestBody NonMemberGetOrderDtoReq nonMemberGetOrderDtoReq) {

        try {
            NonMemberOrderListDtoRes nonMemberOrderListDtoRes = nonMemberOrderService.retrieveNonMemberOrders(nonMemberGetOrderDtoReq);
            return new BaseResponse<>(nonMemberOrderListDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
