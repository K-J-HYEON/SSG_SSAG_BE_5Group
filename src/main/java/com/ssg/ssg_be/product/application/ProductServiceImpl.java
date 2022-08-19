package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import com.ssg.ssg_be.review.infrastructure.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryConnRepository categoryConnRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository, ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.categoryConnRepository = categoryConnRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDtoRes> retrieveAllProduct() throws BaseException {
        try {
            return retrieveProductAndReview(categoryConnRepository.findAllBy());
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByMediumCategoryId(mediumCategoryId));
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findBySmallCategorySmallCategoryId(smallCategoryId));
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByLargeCategoryId(largeCategoryId));
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveSearch(String searchWord) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByProductNameContains(searchWord));
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductInfoDtoRes retrieveProductBasic(Long productId) throws BaseException {
        //TODO #1 : 상품 사진 조회

        //TODO #2 : 상품 기본 정보 조회(상품명, 가격, 할인율, 가게명)

        //TODO #3 : 리뷰 개수 조회


        return null;
    }

    @Override
    public ProductDetailInfoDtoRes retrieveProductDetail(Long productId) throws BaseException {
        //TODO #4 : 상품 번호 조회

        //TODO #5 : 상세 이미지 조회

        return null;
    }

    public List<ProductDtoRes> retrieveProductAndReview(List<CategoryProductDtoRes> products) {

        List<ReviewTotalDto> reviewTotalDtos = new ArrayList<>();

        for(CategoryProductDtoRes categoryProductDtoRes : products) {
            if(reviewRepository.existsByProduct_ProductId(categoryProductDtoRes.getProduct().getProductId())) {
                reviewTotalDtos.add(reviewRepository.retrieveReviewAvg(categoryProductDtoRes.getProduct().getProductId()));
            } else {
                reviewTotalDtos.add(null);
            }
        }

        List<ProductDtoRes> productDtoResList = new ArrayList<>();
        ProductDtoRes productDtoRes;

        for(int i = 0; i < products.size(); i++) {
            productDtoRes = new ProductDtoRes(products.get(i), reviewTotalDtos.get(i));
            productDtoResList.add(productDtoRes);
        }

        return productDtoResList;
    }

}
