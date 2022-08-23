package com.ssg.ssg_be.cart.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDtoReq {

    private List<CartListDto> cartList;
}
