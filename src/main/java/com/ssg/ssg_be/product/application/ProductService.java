package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;

import java.util.List;

public interface ProductService {

    List<ProductDtoRes> retrieveAllProduct() throws BaseException;
    List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveSearch(String searchWord) throws BaseException;


}
