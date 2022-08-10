package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @GetMapping("/product/medium/{mediumCategoryId}")
    public BaseResponse<List<CategoryProductDtoRes>> retrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId) {

        try {
            List<CategoryProductDtoRes> categoryProductDtoRes = productService.retrieveMediumCategoryProduct(mediumCategoryId);
            return new BaseResponse<>(categoryProductDtoRes);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/small/{smallCategoryId}")
    public BaseResponse<List<CategoryProductDtoRes>> retrieveSmallCategoryProduct(@PathVariable Long smallCategoryId) {

        try {
            List<CategoryProductDtoRes> categoryProductDtoRes = productService.retrieveSmallCategoryProduct(smallCategoryId);
            return new BaseResponse<>(categoryProductDtoRes);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/large/{largeCategoryId}")
    public BaseResponse<List<CategoryProductDtoRes>> retrieveLargeCategoryProduct(@PathVariable Long largeCategoryId) {

        try {
            List<CategoryProductDtoRes> categoryProductDtoRes = productService.retrieveLargeCategoryProduct(largeCategoryId);
            return new BaseResponse<>(categoryProductDtoRes);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}


