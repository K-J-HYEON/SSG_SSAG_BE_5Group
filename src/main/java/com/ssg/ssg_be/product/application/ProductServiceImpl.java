package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.domain.LargeCategory;
import com.ssg.ssg_be.category.domain.MediumCategory;
import com.ssg.ssg_be.category.domain.SmallCategory;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.category.infrastructure.LargeCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.MediumCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.SmallCategoryRepository;
import com.ssg.ssg_be.history.domain.CategoryHistory;
import com.ssg.ssg_be.history.domain.SearchHistory;
import com.ssg.ssg_be.history.domain.ViewHistory;
import com.ssg.ssg_be.history.infrastructure.CategoryHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.SearchHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.ViewHistoryRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.DetailImgRepository;
import com.ssg.ssg_be.product.infrastructure.ProductImgRepository;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.review.domain.ReviewTotalDto;
import com.ssg.ssg_be.review.infrastructure.ReviewRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.ssg_be.wish.domain.Wish;
import com.ssg.ssg_be.wish.domain.WishDto;
import com.ssg.ssg_be.wish.infrastructure.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private CategoryConnRepository categoryConnRepository;
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;
    private ProductImgRepository productImgRepository;
    private DetailImgRepository detailImgRepository;
    private ProductOptionRepository productOptionRepository;
    private WishRepository wishRepository;
    private ViewHistoryRepository viewHistoryRepository;
    private UserRepository userRepository;
    private SearchHistoryRepository searchHistoryRepository;
    private CategoryHistoryRepository categoryHistoryRepository;
    private LargeCategoryRepository largeCategoryRepository;
    private MediumCategoryRepository mediumCategoryRepository;
    private SmallCategoryRepository smallCategoryRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository, ReviewRepository reviewRepository, ProductRepository productRepository, ProductImgRepository productImgRepository, DetailImgRepository detailImgRepository, ProductOptionRepository productOptionRepository, WishRepository wishRepository, ViewHistoryRepository viewHistoryRepository, UserRepository userRepository, SearchHistoryRepository searchHistoryRepository, CategoryHistoryRepository categoryHistoryRepository, LargeCategoryRepository largeCategoryRepository, MediumCategoryRepository mediumCategoryRepository, SmallCategoryRepository smallCategoryRepository) {
        this.categoryConnRepository = categoryConnRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productImgRepository = productImgRepository;
        this.detailImgRepository = detailImgRepository;
        this.productOptionRepository = productOptionRepository;
        this.wishRepository = wishRepository;
        this.viewHistoryRepository = viewHistoryRepository;
        this.userRepository = userRepository;
        this.searchHistoryRepository = searchHistoryRepository;
        this.categoryHistoryRepository = categoryHistoryRepository;
        this.largeCategoryRepository = largeCategoryRepository;
        this.mediumCategoryRepository = mediumCategoryRepository;
        this.smallCategoryRepository = smallCategoryRepository;
    }

    @Override
    public ProductSliceDtoRes retrieveAllProduct(Long userId, Pageable pageable) throws BaseException {
        try {
            return retrieveProductAndReview(categoryConnRepository.findAllBy(pageable), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductSliceDtoRes retrieveMediumCategoryProduct(Long mediumCategoryId, Long userId, Pageable pageable) throws BaseException {

        MediumCategory mediumCategory = mediumCategoryRepository.getById(mediumCategoryId);

        try {
            // 최근 본 카테고리(중)
            if (userId != -1L) {
                User user = userRepository.getById(userId);
                if(!categoryHistoryRepository.existsByUserUserIdAndCategoryTypeAndCategoryId(userId, 1, mediumCategoryId)) {
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryId(mediumCategoryId)
                            .categoryName(mediumCategory.getMediumCategoryTitle())
                            .categoryType(1)
                            .user(user)
                            .build());
                } else {
                    CategoryHistory categoryHistory = categoryHistoryRepository.findByUserUserIdAndCategoryTypeAndCategoryId(userId, 1, mediumCategoryId);
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryHistoryId(categoryHistory.getCategoryHistoryId())
                            .categoryId(categoryHistory.getCategoryId())
                            .categoryName(categoryHistory.getCategoryName())
                            .categoryType(categoryHistory.getCategoryType())
                            .user(categoryHistory.getUser())
                            .build());
                }
            }

            return retrieveProductAndReview(categoryConnRepository.findByMediumCategoryId(mediumCategoryId, pageable), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductSliceDtoRes retrieveSmallCategoryProduct(Long smallCategoryId, Long userId, Pageable pageable) throws BaseException {

        SmallCategory smallCategory = smallCategoryRepository.getById(smallCategoryId);

        try {
            // 최근 본 카테고리(소)
            if (userId != -1L) {
                User user = userRepository.getById(userId);
                if(!categoryHistoryRepository.existsByUserUserIdAndCategoryTypeAndCategoryId(userId, 2, smallCategoryId)) {
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryId(smallCategoryId)
                            .categoryName(smallCategory.getSmallCategoryTitle())
                            .categoryType(2)
                            .user(user)
                            .build());
                } else {
                    CategoryHistory categoryHistory = categoryHistoryRepository.findByUserUserIdAndCategoryTypeAndCategoryId(userId, 2, smallCategoryId);
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryHistoryId(categoryHistory.getCategoryHistoryId())
                            .categoryId(categoryHistory.getCategoryId())
                            .categoryName(categoryHistory.getCategoryName())
                            .categoryType(categoryHistory.getCategoryType())
                            .user(categoryHistory.getUser())
                            .build());
                }
            }
            return retrieveProductAndReview(categoryConnRepository.findBySmallCategorySmallCategoryId(smallCategoryId, pageable), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductSliceDtoRes retrieveLargeCategoryProduct(Long largeCategoryId, Long userId, Pageable pageable) throws BaseException {

        LargeCategory largeCategory = largeCategoryRepository.getById(largeCategoryId);

        try {
            // 최근 본 카테고리(대)
            if (userId != -1L) {
                User user = userRepository.getById(userId);
                if(!categoryHistoryRepository.existsByUserUserIdAndCategoryTypeAndCategoryId(userId, 0, largeCategoryId)) {
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryId(largeCategoryId)
                            .categoryName(largeCategory.getTitle())
                            .categoryType(0) // 0 large
                            .user(user)
                            .build());
                } else {
                    CategoryHistory categoryHistory = categoryHistoryRepository.findByUserUserIdAndCategoryTypeAndCategoryId(userId, 0, largeCategoryId);
                    categoryHistoryRepository.save(CategoryHistory.builder()
                            .categoryHistoryId(categoryHistory.getCategoryHistoryId())
                            .categoryId(categoryHistory.getCategoryId())
                            .categoryName(categoryHistory.getCategoryName())
                            .categoryType(categoryHistory.getCategoryType())
                            .user(categoryHistory.getUser())
                            .build());
                }
            }

            return retrieveProductAndReview(categoryConnRepository.findByLargeCategoryId(largeCategoryId, pageable), userId);
        } catch(Exception exception) {
            throw new BaseException(PRODUCT_RETRIEVE_FAILED);
        }
    }

    @Override
    public ProductSliceDtoRes retrieveSearch(String searchWord, Long userId, Pageable pageable) throws BaseException {

        try {
            // 최근 검색 조회
            if (userId != -1L) {
                User user = userRepository.getById(userId);
                if(!searchHistoryRepository.existsByUserUserIdAndSearchWord(userId, searchWord)) {
                    searchHistoryRepository.save(SearchHistory.builder()
                            .searchWord(searchWord)
                            .user(user)
                            .build());
                } else {
                    SearchHistory searchHistory = searchHistoryRepository.findByUserUserIdAndSearchWord(userId, searchWord);
                    searchHistoryRepository.save(SearchHistory.builder()
                            .searchHistoryId(searchHistory.getSearchHistoryId())
                            .searchWord(searchHistory.getSearchWord())
                            .user(searchHistory.getUser())
                            .build());
                }
            }

            return retrieveProductAndReview(categoryConnRepository.findByProductNameContaining(searchWord, pageable), userId);

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
        ReviewTotalDto reviewTotalDto = null;;
        try {
            if(reviewRepository.existsByProduct_ProductId(productId)) {
                reviewTotalDto = reviewRepository.retrieveReviewAvg(productId);
            }
        } catch(Exception exception) {
            throw new BaseException(REVIEW_TOTAL_RETRIEVE_FAILED);
        }

        // 최근 상품 조회
        if(userId != -1L) {
            User user = userRepository.getById(userId);

            if(!viewHistoryRepository.existsByUserUserIdAndProductId(userId, productId)) {
                viewHistoryRepository.save(ViewHistory.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .productImg(product.getImgUrl())
                        .productId(product.getProductId())
                        .user(user)
                        .build());
            } else {
                ViewHistory viewHistory = viewHistoryRepository.findByUserUserIdAndProductId(userId, productId);
                viewHistoryRepository.save(ViewHistory.builder()
                        .viewHistoryId(viewHistory.getViewHistoryId())
                        .name(viewHistory.getName())
                        .price(viewHistory.getPrice())
                        .productImg(viewHistory.getProductImg())
                        .productId(viewHistory.getProductId())
                        .user(viewHistory.getUser())
                        .build());
            }
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
    public List<ProductColorDtoRes> retrieveProductColor(Long productId) throws BaseException {
        try {
            return productOptionRepository.getColorIds(productId);
        } catch(Exception exception) {
            throw new BaseException(OPTION_COLOR_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<ProductSizeDtoRes> retrieveProductSize(Long productId, Long colorId) throws BaseException {
        try {
            List<ProductOption> productOptions = productOptionRepository.findAllByProductProductIdAndColorColorId(productId, colorId);
            List<ProductSizeDtoRes> productSizeDtoRes = new ArrayList<>();

            productOptions.forEach(productOption -> productSizeDtoRes.add(ProductSizeDtoRes.builder()
                            .productOptionId(productOption.getProductOptionId())
                            .sizeId(productOption.getSize().getSizeId())
                            .size(productOption.getSize().getSize())
                            .stock(productOption.getStock())
                    .build())
            );

            return productSizeDtoRes;
        } catch(Exception exception) {
            throw new BaseException(OPTION_SIZE_RETRIEVE_FAILED);
        }
    }

    public ProductSliceDtoRes retrieveProductAndReview(Slice<CategoryProductDtoRes> products, Long userId) {

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

        int i = 0;

        for(CategoryProductDtoRes categoryProductDtoRes : products.getContent()) {
            productDtoRes = new ProductDtoRes(categoryProductDtoRes, reviewTotalDtos.get(i), wishDtos.get(i));
            productDtoResList.add(productDtoRes);
            i++;
        }

        return ProductSliceDtoRes.builder()
                .pageNumber(products.getNumber())
                .contentSize(products.getNumberOfElements())
                .last(products.isLast())
                .next(products.hasNext())
                .productDtoRes(productDtoResList)
                .build();
    }



}
