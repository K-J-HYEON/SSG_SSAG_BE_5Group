package com.ssg.ssg_be.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartTotalDtoRes {
    private int totalOrder;
    private int totalSale;
    private int totalAmount;
    private List<StoreList> storeList;
}
