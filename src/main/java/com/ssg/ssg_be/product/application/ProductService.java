package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.ProductDtoReq;

public interface ProductService {
    void addProduct(ProductDtoReq productDtoReq) throws BaseException;
}
