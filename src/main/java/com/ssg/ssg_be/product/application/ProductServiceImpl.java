package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.config.BaseResponseStatus;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ProductDto;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
import com.ssg.ssg_be.product.infrastructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMRepository categoryMRepository;
    private final CategorySRepository categorySRepository;
    private final CategoryConnRepository categoryConnRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, CategoryMRepository categoryMRepository, CategorySRepository categorySRepository, CategoryConnRepository categoryConnRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.categoryMRepository = categoryMRepository;
        this.categorySRepository = categorySRepository;
        this.categoryConnRepository = categoryConnRepository;
    }

    public Optional<Product> retrieveProduct(Long productId) throws BaseException {
        try {
            Optional<Product> productDto = productRepository.findById(productId);
            if (productDto == null) {
                throw new BaseException(BaseResponseStatus.NO_LOOKUP_VALUE);
            }
            return productDto;
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_RETRIEVE_PRODUCT);
        }
    }


    // 상품 목록 조회(카테고리)
    // 뭔가 이상함 고쳐야함
    public Optional<Product> retrieveProductList(Long productId) throws BaseException {
        try {
            Optional<Product> productDto = productRepository.findById(productId);
            if (productDto == null) {
                throw new BaseException(BaseResponseStatus.NO_LOOKUP_VALUE);
            }
            return productDto;
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_RETRIEVE_PRODUCT);
        }
    }

}
