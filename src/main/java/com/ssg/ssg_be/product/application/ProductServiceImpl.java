package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.domain.SmallCategoryIdDto;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.category.infrastructure.SmallCategoryRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.SEARCH_RETRIEVE_FAILED;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryConnRepository categoryConnRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository) {
        this.categoryConnRepository = categoryConnRepository;
    }

    @Override
    public List<MediumProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException {

        try {
            return categoryConnRepository.findByMediumCategoryId(mediumCategoryId);
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

//    public List<ProductDtoRes> retrieveSearch(Long productId) throws BaseException {
//        try {
//            return productRepository.findByNameContains(productId);
//        } catch (Exception exception) {
//            throw new BaseException(SEARCH_RETRIEVE_FAILED);
//        }
//    }
//
//    public List<CategoryDtoRes> retrieveProductList(Long categoryId) throws BaseException {
//        try {
//            return largeCategoryRepository.findByNameContains(categoryId);
//        } catch (Exception exception) {
//            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
//        }
//    }
//
//    public List<CategoryMDtoRes> retrieveProductListDetail(Long categoryMId) throws BaseException {
//        try {
//            return mediumCategoryRepository.findByNameContains(categoryMId);
//        } catch (Exception exception) {
//            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
//        }
//    }
//
//    public List<CategorySDtoRes> retrieveProductListDetailS(Long categorySId) throws BaseException {
//        try {
//            return smallCategoryRepository.findByNameContains(categorySId);
//        } catch (Exception exception) {
//            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
//        }
//    }

    // 소분류에서 아이템으로 넘어가는 단계 구현은 파라미터 두개를 받아서 넘기는 과정인지 어떻게 넘기는지 의문 / 상품 검색 단계에서 이미 상품을 찾는 코드 구현함
}
