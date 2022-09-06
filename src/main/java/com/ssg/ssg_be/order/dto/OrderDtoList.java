package com.ssg.ssg_be.order.dto;

import com.ssg.ssg_be.signup.dto.UserDtoRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDtoList {
    private Long orderListId;
    private UserDtoRes user;
    private int refundType;
    private String recipient;
    private String addrName;
    private String streetAddr;
    private String zipCode;
    private String shippingMsg;
    private LocalDateTime createAt;
    private List<OrderDto> orders;
}
