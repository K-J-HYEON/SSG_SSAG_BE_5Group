package com.ssg.ssg_be.order.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.order.application.OrderService;
import com.ssg.ssg_be.order.dto.OrderDtoList;
import com.ssg.ssg_be.order.dto.OrderUpdateDtoReq;
import com.ssg.ssg_be.order.dto.OrderListDtoReq;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class OrderController {

    private final OrderService orderService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public OrderController(OrderService orderService, JwtTokenProvider jwtTokenProvider) {
        this.orderService = orderService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/order")
    public BaseResponse<String> createOrder(@RequestBody OrderListDtoReq orderListDtoReq) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));
        String result = "";

        try {
            orderService.createOrder(orderListDtoReq, userId);
            result = "상품 주문에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/order")
    public BaseResponse<List<OrderDtoList>> retrieveOrders() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<OrderDtoList> orderDtoListRes = orderService.retrieveOrders(userId);
            return new BaseResponse<>(orderDtoListRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/cancel")
    public BaseResponse<String> cancelOrder(@RequestBody OrderUpdateDtoReq updateDtoReq) {
        String result = "";

        try {
            orderService.cancelOrder(updateDtoReq);
            result = "주문이 취소되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/return")
    public BaseResponse<String> returnOrder(@RequestBody OrderUpdateDtoReq updateDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            orderService.updateOrder(updateDtoReq, userId, 2);
            result = "반품 신청 되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/order/exchange")
    public BaseResponse<String> exchangeOrder(@RequestBody OrderUpdateDtoReq updateDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            orderService.updateOrder(updateDtoReq, userId, 3);
            result = "교환 신청되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/order/{orderId}")
    public BaseResponse<String> deleteOrder(@PathVariable Long orderId) {
        String result = "";

        try {
            orderService.deleteOrder(orderId);
            result = "주문 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
