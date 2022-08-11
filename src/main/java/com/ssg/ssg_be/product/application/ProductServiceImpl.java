package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import com.ssg.ssg_be.review.infrastructure.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.SEARCH_RETRIEVE_FAILED;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryConnRepository categoryConnRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository, ReviewRepository reviewRepository) {
        this.categoryConnRepository = categoryConnRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByMediumCategoryId(mediumCategoryId));
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findBySmallCategorySmallCategoryId(smallCategoryId));
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByLargeCategoryId(largeCategoryId));
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
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
