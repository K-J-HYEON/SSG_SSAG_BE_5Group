package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;

import java.util.List;

public interface ProductService {

    List<CategoryProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException;
    List<CategoryProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException;
    List<CategoryProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException;

}
