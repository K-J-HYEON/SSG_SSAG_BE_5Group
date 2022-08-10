package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.category.domain.CategoryDtoRes;
import com.ssg.ssg_be.category.domain.CategoryMDtoRes;
import com.ssg.ssg_be.category.domain.CategorySDtoRes;
import com.ssg.ssg_be.product.application.ProductServiceImpl;
import com.ssg.ssg_be.product.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class ProductController {

    private ProductServiceImpl productServiceImpl;
    private Long categoryId;

    @ResponseBody
    @GetMapping("/product/{searchWord}")
    public BaseResponse<List<ProductDtoRes>> retrieveSearch(@PathVariable String searchWord) {
        try {
            List<ProductDtoRes> productDtoRes = productServiceImpl.retrieveSearch(Long.valueOf(searchWord));
            return new BaseResponse<>(productDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product")
    public BaseResponse<List<CategoryDtoRes>> retrieveProductList() {
        try {
            List<CategoryDtoRes> CategoryDtoRes = productServiceImpl.retrieveProductList(categoryId);
            return new BaseResponse<>(CategoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/{productId}")
    public BaseResponse<List<CategoryMDtoRes>> retrieveProductListDetail(@PathVariable String productId) {
        try {
            List<CategoryMDtoRes> CategoryMDtoRes = productServiceImpl.retrieveProductListDetail(Long.valueOf(productId));
            return new BaseResponse<>(CategoryMDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/product/{productId}/{small}")
    public BaseResponse<List<CategorySDtoRes>> retrieveProductListDetailS(@PathVariable String productId, @PathVariable String small) {
        try {
            List<CategorySDtoRes> CategorySDtoRes = productServiceImpl.retrieveProductListDetailS(Long.valueOf(small));
            return new BaseResponse<>(CategorySDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }


}


