package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.*;

import java.util.List;

public interface ProductService {

    List<ProductDtoRes> retrieveAllProduct() throws BaseException;
    List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException;
    List<ProductDtoRes> retrieveSearch(String searchWord) throws BaseException;
    ProductInfoDtoRes retrieveProductBasic(Long productId) throws BaseException;
    List<DetailImgDtoRes> retrieveProductDetail(Long productId) throws BaseException;
    List<ProductOptionDtoRes> retrieveProductOption(Long productId) throws BaseException;

}
