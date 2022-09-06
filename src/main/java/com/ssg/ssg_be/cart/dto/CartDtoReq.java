package com.ssg.ssg_be.cart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDtoReq {

    private List<CartListDto> cartList;
}
