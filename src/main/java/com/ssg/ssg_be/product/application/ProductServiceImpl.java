package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.DetailImgRepository;
import com.ssg.ssg_be.product.infrastructure.ProductImgRepository;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
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
    private final ProductImgRepository productImgRepository;
    private final DetailImgRepository detailImgRepository;
    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository, ReviewRepository reviewRepository, ProductRepository productRepository, ProductImgRepository productImgRepository, DetailImgRepository detailImgRepository, ProductOptionRepository productOptionRepository) {
        this.categoryConnRepository = categoryConnRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productImgRepository = productImgRepository;
        this.detailImgRepository = detailImgRepository;
        this.productOptionRepository = productOptionRepository;
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

        // 상품 사진 조회
        List<ProductImgDtoRes> productImgDtoRes = new ArrayList<>();
        try {
            List<ProductImg> productImgs = productImgRepository.findByProductProductIdOrderByPriority(productId);

            productImgs.forEach(productImg -> productImgDtoRes.add(ProductImgDtoRes.builder()
                    .productImgId(productImg.getProductImgId())
                    .originName(productImg.getOriginName())
                    .saveName(productImg.getSaveName())
                    .imgUrl(productImg.getImgUrl())
                    .priority(productImg.getPriority())
                    .build()
            ));
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_IMG_RETRIEVE_FAILED);
        }

        // 상품 기본 정보 조회
        Product product;
        try {
            product = productRepository.getById(productId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }

        // 리뷰 개수 조회
        ReviewTotalDto reviewTotalDto;
        try {
            reviewTotalDto = reviewRepository.retrieveReviewAvg(productId);
        } catch(Exception exception) {
            throw new BaseException(REVIEW_TOTAL_RETRIEVE_FAILED);
        }

        return ProductInfoDtoRes.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .sale(product.getSale())
                .storeId(product.getStore().getStoreId())
                .storeName(product.getStore().getName())
                .reviewTotal(reviewTotalDto)
                .productImg(productImgDtoRes)
                .build();
    }

    @Override
    public List<DetailImgDtoRes> retrieveProductDetail(Long productId) throws BaseException {

        try {
            List<DetailImg> detailImgs = detailImgRepository.findByProductProductIdOrderByPriority(productId);
            List<DetailImgDtoRes> detailImgDtoRes = new ArrayList<>();

            detailImgs.forEach(detailImg -> detailImgDtoRes.add(DetailImgDtoRes.builder()
                            .detailImgId(detailImg.getDetailImgId())
                            .originName(detailImg.getOriginName())
                            .saveName(detailImg.getSaveName())
                            .imgUrl(detailImg.getImgUrl())
                            .priority(detailImg.getPriority())
                            .build()
            ));

            return detailImgDtoRes;
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_IMG_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductOptionDtoRes> retrieveProductOption(Long productId) throws BaseException {

        try {
            List<ProductOption> productOption = productOptionRepository.findByProductProductId(productId);
            List<ProductOptionDtoRes> productOptionDtoRes = new ArrayList<>();

            productOption.forEach(p -> productOptionDtoRes.add(ProductOptionDtoRes.builder()
                    .productOptionId(p.getProductOptionId())
                    .size(p.getSize())
                    .color(p.getColor())
                    .modelNumber(p.getModelNumber())
                    .stock(p.getStock())
                    .build())
            );

            return productOptionDtoRes;
        } catch(Exception exception) {
            throw new BaseException(OPTION_RETRIEVE_FAILED);
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
