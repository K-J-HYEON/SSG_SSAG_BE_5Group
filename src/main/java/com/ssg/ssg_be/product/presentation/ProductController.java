package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
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
    @GetMapping("/products/all")
    public BaseResponse<List<ProductDtoRes>> retrieveAllProduct() {

        try {
            List<ProductDtoRes> product = productService.retrieveAllProduct();
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/products/medium/{mediumCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveMediumCategoryProduct(mediumCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/products/small/{smallCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveSmallCategoryProduct(@PathVariable Long smallCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveSmallCategoryProduct(smallCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/products/large/{largeCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveLargeCategoryProduct(@PathVariable Long largeCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveLargeCategoryProduct(largeCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/products/search/{searchWord}")
    public BaseResponse<List<ProductDtoRes>> retrieveSearch(@PathVariable String searchWord) {

        try {
            List<ProductDtoRes> product = productService.retrieveSearch(searchWord);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}


