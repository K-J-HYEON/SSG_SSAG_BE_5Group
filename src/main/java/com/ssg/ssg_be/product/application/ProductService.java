package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {

    ProductSliceDtoRes retrieveAllProduct(Long userId, Pageable pageable) throws BaseException;
    ProductTestWithNQRes testWithNativeQuery(Pageable pageable, Long userId) throws BaseException;
    ProductSliceTestDto testWithSeparation(Pageable pageable) throws BaseException;
    ReviewAndWishDto testWithReviewAndWish(Pageable pageable, Long userId, List<Long> productIds) throws BaseException;
    ProductSliceDtoRes retrieveMediumCategoryProduct(Long mediumCategoryId, Long userId, Pageable pageable) throws BaseException;
    ProductSliceDtoRes retrieveSmallCategoryProduct(Long smallCategoryId, Long userId, Pageable pageable) throws BaseException;
    ProductSliceDtoRes retrieveLargeCategoryProduct(Long largeCategoryId, Long userId, Pageable pageable) throws BaseException;
    ProductSliceDtoRes retrieveSearch(String searchWord, Long userId, Pageable pageable) throws BaseException;
    ProductInfoDtoRes retrieveProductBasic(Long productId, Long userId) throws BaseException;
    List<DetailImgDtoRes> retrieveProductDetail(Long productId) throws BaseException;
    List<ProductColorDtoRes> retrieveProductColor(Long productId) throws BaseException;
    List<ProductSizeDtoRes> retrieveProductSize(Long productId, Long colorId) throws BaseException;
}
