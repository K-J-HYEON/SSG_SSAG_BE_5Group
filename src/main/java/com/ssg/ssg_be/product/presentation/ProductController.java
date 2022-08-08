package com.ssg.ssg_be.product.presentation;


import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.application.ProductServiceImpl;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comm-users")
public class ProductController {

    private final ProductService productService;
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl ) {
        this.productService = productService;
        this.productServiceImpl = productServiceImpl;
    }

    // 상품 검색
    @ResponseBody
    @GetMapping("/product/{productSearch}")
    public BaseResponse<ProductDtoRes> retrieveProduct(@PathVariable String productSearch) {
        try {
            Optional<Product> productDtoRes = productServiceImpl.retrieveProduct();
            return new BaseResponse<>(productDtoRes);

        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    // 카테고리 클릭했을 때 => 대분류 중분류 소분류 순으로
    // 상품 목록 조회(카테고리)
    @ResponseBody
    @GetMapping("/product/{productid}")
    public BaseResponse<ProductDtoRes> retrieveProductList(@PathVariable String productid) {
        try {
            Optional<Product> productDtoRes = productServiceImpl.retrieveProduct();
            return new BaseResponse<>(productDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    // 상품 상세 조회(카테고리)

}
