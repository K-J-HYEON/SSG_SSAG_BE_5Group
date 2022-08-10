package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponseStatus;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.ssg.config.BaseResponseStatus.CATEGORY_RETRIEVE_FAILED;
import static com.ssg.config.BaseResponseStatus.SEARCH_RETRIEVE_FAILED;

@Service
public class ProductServiceImpl {

    @Autowired
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMRepository categoryMRepository;
    private final CategorySRepository categorySRepository;
    private final CategoryConnRepository categoryConnRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, CategoryMRepository categoryMRepository, CategorySRepository categorySRepository, CategoryConnRepository categoryConnRepository, BaseResponseStatus baseResponseStatus) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.categoryMRepository = categoryMRepository;
        this.categorySRepository = categorySRepository;
        this.categoryConnRepository = categoryConnRepository;
    }

    public List<ProductDtoRes> retrieveSearch(Long productId) throws BaseException {
        try {
            return productRepository.findByNameContains(productId);
        } catch (Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    public List<CategoryDtoRes> retrieveProductList(Long categoryId) throws BaseException {
        try {
            return categoryRepository.findByNameContains(categoryId);
        } catch (Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    public List<CategoryMDtoRes> retrieveProductListDetail(Long categoryMId) throws BaseException {
        try {
            return categoryMRepository.findByNameContains(categoryMId);
        } catch (Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    public List<CategorySDtoRes> retrieveProductListDetailS(Long categorySId) throws BaseException {
        try {
            return categorySRepository.findByNameContains(categorySId);
        } catch (Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    // 소분류에서 아이템으로 넘어가는 단계 구현은 파라미터 두개를 받아서 넘기는 과정인지 어떻게 넘기는지 의문 / 상품 검색 단계에서 이미 상품을 찾는 코드 구현함
}
