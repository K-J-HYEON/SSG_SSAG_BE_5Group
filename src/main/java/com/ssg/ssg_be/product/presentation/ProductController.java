package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductController {

    private final ProductService productService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ProductController(ProductService productService, JwtTokenProvider jwtTokenProvider) {
        this.productService = productService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @ResponseBody
    @GetMapping("/non-users/products/all")
    public BaseResponse<List<ProductDtoRes>> retrieveAllProduct() {
        try {
            List<ProductDtoRes> product = productService.retrieveAllProduct(-1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/all")
    public BaseResponse<List<ProductDtoRes>> userRetrieveAllProduct() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ProductDtoRes> product = productService.retrieveAllProduct(userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/non-users/products/medium/{mediumCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveMediumCategoryProduct(mediumCategoryId, -1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/medium/{mediumCategoryId}")
    public BaseResponse<List<ProductDtoRes>> userRetrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ProductDtoRes> product = productService.retrieveMediumCategoryProduct(mediumCategoryId, userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/non-users/products/small/{smallCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveSmallCategoryProduct(@PathVariable Long smallCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveSmallCategoryProduct(smallCategoryId, -1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/small/{smallCategoryId}")
    public BaseResponse<List<ProductDtoRes>> userRetrieveSmallCategoryProduct(@PathVariable Long smallCategoryId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ProductDtoRes> product = productService.retrieveSmallCategoryProduct(smallCategoryId, userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/non-users/products/large/{largeCategoryId}")
    public BaseResponse<List<ProductDtoRes>> retrieveLargeCategoryProduct(@PathVariable Long largeCategoryId) {

        try {
            List<ProductDtoRes> product = productService.retrieveLargeCategoryProduct(largeCategoryId, -1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/large/{largeCategoryId}")
    public BaseResponse<List<ProductDtoRes>> userRetrieveLargeCategoryProduct(@PathVariable Long largeCategoryId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ProductDtoRes> product = productService.retrieveLargeCategoryProduct(largeCategoryId, userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/search/{searchWord}")
    public BaseResponse<List<ProductDtoRes>> retrieveSearch(@PathVariable String searchWord) {

        try {
            List<ProductDtoRes> product = productService.retrieveSearch(searchWord, -1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/non-users/products/search/{searchWord}")
    public BaseResponse<List<ProductDtoRes>> userRetrieveSearch(@PathVariable String searchWord) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ProductDtoRes> product = productService.retrieveSearch(searchWord, userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/non-users/products/info/{productId}")
    public BaseResponse<ProductInfoDtoRes> retrieveProductBasic(@PathVariable Long productId) {
        try {
            ProductInfoDtoRes product = productService.retrieveProductBasic(productId, -1L);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/users/products/info/{productId}")
    public BaseResponse<ProductInfoDtoRes> userRetrieveProductBasic(@PathVariable Long productId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductInfoDtoRes product = productService.retrieveProductBasic(productId, userId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/products/detail-info/{productId}")
    public BaseResponse<List<DetailImgDtoRes>> retrieveProductDetail(@PathVariable Long productId) {
        try {
            List<DetailImgDtoRes> product = productService.retrieveProductDetail(productId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/products/options/{productId}")
    public BaseResponse<List<ProductOptionDtoRes>> retrieveProductOption(@PathVariable Long productId) {
        try {
            List<ProductOptionDtoRes> product = productService.retrieveProductOption(productId);
            return new BaseResponse<>(product);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}


