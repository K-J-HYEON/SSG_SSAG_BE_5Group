package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.*;

import java.util.List;

public interface ProductService {

    List<ProductDtoRes> retrieveAllProduct(Long userId) throws BaseException;
    List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId, Long userId) throws BaseException;
    List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId, Long userId) throws BaseException;
    List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId, Long userId) throws BaseException;
    List<ProductDtoRes> retrieveSearch(String searchWord, Long userId) throws BaseException;
    ProductInfoDtoRes retrieveProductBasic(Long productId, Long userId) throws BaseException;
    List<DetailImgDtoRes> retrieveProductDetail(Long productId) throws BaseException;
    List<ProductColorDtoRes> retrieveProductColor(Long productId) throws BaseException;
    List<ProductSizeDtoRes> retrieveProductSize(Long productId, Long colorId) throws BaseException;

}
