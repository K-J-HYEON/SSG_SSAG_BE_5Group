package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.domain.CategoryProductDtoRes;
import com.ssg.ssg_be.product.domain.ProductDtoRes;
import com.ssg.utils.s3.S3UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class ProductController {

    private final ProductService productService;
    private final S3UploaderService s3UploaderService;

    @Autowired
    public ProductController(ProductService productService, S3UploaderService s3UploaderService) {
        this.productService = productService;
        this.s3UploaderService = s3UploaderService;
    }

    @ResponseBody
    @GetMapping("/product/medium/{mediumCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveMediumCategoryProduct(mediumCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/small/{smallCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveSmallCategoryProduct(@PathVariable Long smallCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveSmallCategoryProduct(smallCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/large/{largeCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveLargeCategoryProduct(@PathVariable Long largeCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveLargeCategoryProduct(largeCategoryId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PostMapping("/images")
    public BaseResponse<String> upload(@RequestParam("images") MultipartFile multipartFile) {
        try {
            String result = s3UploaderService.upload(multipartFile, "product");
            return new BaseResponse<>(result);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}


