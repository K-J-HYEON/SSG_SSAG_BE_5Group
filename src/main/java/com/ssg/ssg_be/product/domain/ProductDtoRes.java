package com.ssg.ssg_be.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDtoRes {
    private String name;
    private int product_number;
    private int price;
    private int delivery_fee;
    private String color;
    private String size;
    private int sale;

}
