package com.ssg.ssg_be.order.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.order.application.OrderService;
import com.ssg.ssg_be.order.domain.OrderDtoListRes;
import com.ssg.ssg_be.order.domain.OrderDtoRes;
import com.ssg.ssg_be.order.domain.OrderListDtoReq;
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

    @ResponseBody
    @GetMapping("/order")
    public BaseResponse<List<OrderDtoListRes>> retrieveOrders() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<OrderDtoListRes> orderDtoListRes = orderService.retrieveOrders(userId);
            return new BaseResponse<>(orderDtoListRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
