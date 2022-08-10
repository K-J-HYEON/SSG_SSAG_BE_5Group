package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.MediumProductDtoRes;
import com.ssg.ssg_be.product.domain.ProductDtoRes;

import java.util.List;

public interface ProductService {

    List<MediumProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException;
}
