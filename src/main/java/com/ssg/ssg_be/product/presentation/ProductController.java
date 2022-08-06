package com.ssg.ssg_be.product.presentation;


import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.domain.ProductDtoReq;
import com.ssg.ssg_be.product.domain.ProductDtoResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comm-users")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 조회
    @GetMapping("/product")
    public BaseResponse<List<ProductDtoReq>>

    // 상품 상세 조회
    @GetMapping("/product/productid")
    private BaseResponse<String> addUser(@RequestBody ProductDtoReq productImgDtoReq) {

    }



}
