package com.ssg.ssg_be.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StoreList {
    private Long storeId;
    private String storeName;
    private int storeTotal;
    private int storeSale;
    private int storeAmount;
    private List<CartList> cartList;
}
