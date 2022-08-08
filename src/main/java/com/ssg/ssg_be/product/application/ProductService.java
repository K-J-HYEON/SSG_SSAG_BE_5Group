package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.ProductDtoRes;

public interface ProductService {
    void addProduct(ProductDtoRes productDtoRes) throws BaseException;
    // 아래에다가 뭘 더 추가해줘야 할 거 같은데
}
