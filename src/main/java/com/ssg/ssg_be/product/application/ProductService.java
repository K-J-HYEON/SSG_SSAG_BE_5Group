package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.ProductDtoRes;

public interface ProductService {
    void addProduct(ProductDtoRes productDtoRes) throws BaseException;
}
