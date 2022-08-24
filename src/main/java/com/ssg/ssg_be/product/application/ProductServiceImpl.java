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
import com.ssg.ssg_be.wish.domain.Wish;
import com.ssg.ssg_be.wish.domain.WishDto;
import com.ssg.ssg_be.wish.infrastructure.WishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final CategoryConnRepository categoryConnRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProductImgRepository productImgRepository;
    private final DetailImgRepository detailImgRepository;
    private final ProductOptionRepository productOptionRepository;
    private final WishRepository wishRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository, ReviewRepository reviewRepository, ProductRepository productRepository, ProductImgRepository productImgRepository, DetailImgRepository detailImgRepository, ProductOptionRepository productOptionRepository, WishRepository wishRepository) {
        this.categoryConnRepository = categoryConnRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productImgRepository = productImgRepository;
        this.detailImgRepository = detailImgRepository;
        this.productOptionRepository = productOptionRepository;
        this.wishRepository = wishRepository;
    }

    @Override
    public List<ProductDtoRes> retrieveAllProduct(Long userId) throws BaseException {
        try {
            return retrieveProductAndReview(categoryConnRepository.findAllBy(), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId, Long userId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByMediumCategoryId(mediumCategoryId), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId, Long userId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findBySmallCategorySmallCategoryId(smallCategoryId), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId, Long userId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByLargeCategoryId(largeCategoryId), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductDtoRes> retrieveSearch(String searchWord, Long userId) throws BaseException {

        try {
            return retrieveProductAndReview(categoryConnRepository.findByProductNameContains(searchWord), userId);
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductInfoDtoRes retrieveProductBasic(Long productId, Long userId) throws BaseException {

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

        // 찜 여부 조회
        WishDto wishIdDto = null;
        if(userId != -1L) {
            Wish wish = wishRepository.findByUserUserIdAndProductProductId(userId, productId);
            if(wish != null) {
                wishIdDto = new WishDto(wish.getWishId());
            }
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
                .wishDto(wishIdDto)
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

    public List<ProductDtoRes> retrieveProductAndReview(List<CategoryProductDtoRes> products, Long userId) {

        List<ReviewTotalDto> reviewTotalDtos = new ArrayList<>();
        List<WishDto> wishDtos = new ArrayList<>();

        for(CategoryProductDtoRes categoryProductDtoRes : products) {
            if(reviewRepository.existsByProduct_ProductId(categoryProductDtoRes.getProductProductId())) {
                reviewTotalDtos.add(reviewRepository.retrieveReviewAvg(categoryProductDtoRes.getProductProductId()));
            } else {
                reviewTotalDtos.add(null);
            }

            if(userId != -1L) {
                Wish wish = wishRepository.findByUserUserIdAndProductProductId(userId, categoryProductDtoRes.getProductProductId());
                WishDto wishIdDto = null;

                if(wish != null) {
                    wishIdDto = new WishDto(wish.getWishId());
                }
                wishDtos.add(wishIdDto);
            } else {
                wishDtos.add(null);
            }
        }

        List<ProductDtoRes> productDtoResList = new ArrayList<>();
        ProductDtoRes productDtoRes;

        for(int i = 0; i < products.size(); i++) {
            productDtoRes = new ProductDtoRes(products.get(i), reviewTotalDtos.get(i), wishDtos.get(i));
            productDtoResList.add(productDtoRes);
        }

        return productDtoResList;
    }

}
