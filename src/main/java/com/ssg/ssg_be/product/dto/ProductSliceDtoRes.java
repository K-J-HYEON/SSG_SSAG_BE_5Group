package com.ssg.ssg_be.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSliceDtoRes {
    private int pageNumber;
    private int contentSize;
    private boolean last;
    private boolean next;
    private List<ProductDtoRes> productDtoRes;
}
