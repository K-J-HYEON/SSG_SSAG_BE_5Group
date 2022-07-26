package com.ssg.ssg_be.product.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.application.ProductService;
import com.ssg.ssg_be.product.dto.*;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/non-users/products/all")
    public BaseResponse<ProductWithWishDtoRes> retrieveAllProduct(Pageable pageable) {
        try {
            ProductWithWishDtoRes product = productService.retrieveAllProduct(-1L, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/all")
    public BaseResponse<ProductWithWishDtoRes> userRetrieveAllProduct(Pageable pageable) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductWithWishDtoRes product = productService.retrieveAllProduct(userId, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/non-users/products/medium/{mediumCategoryId}")
    public BaseResponse<ProductSliceDtoRes> retrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId, Pageable pageable) {

        try {
            ProductSliceDtoRes product = productService.retrieveMediumCategoryProduct(mediumCategoryId, -1L, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/medium/{mediumCategoryId}")
    public BaseResponse<ProductSliceDtoRes> userRetrieveMediumCategoryProduct(@PathVariable Long mediumCategoryId, Pageable pageable) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductSliceDtoRes product = productService.retrieveMediumCategoryProduct(mediumCategoryId, userId, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/non-users/products/small/{smallCategoryId}")
    public BaseResponse<ProductSliceDtoRes> retrieveSmallCategoryProduct(@PathVariable Long smallCategoryId, Pageable pageable) {

        try {
            ProductSliceDtoRes product = productService.retrieveSmallCategoryProduct(smallCategoryId, -1L, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/small/{smallCategoryId}")
    public BaseResponse<ProductSliceDtoRes> userRetrieveSmallCategoryProduct(@PathVariable Long smallCategoryId, Pageable pageable) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductSliceDtoRes product = productService.retrieveSmallCategoryProduct(smallCategoryId, userId, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/non-users/products/large/{largeCategoryId}")
    public BaseResponse<ProductSliceDtoRes> retrieveLargeCategoryProduct(@PathVariable Long largeCategoryId, Pageable pageable) {

        try {
            ProductSliceDtoRes product = productService.retrieveLargeCategoryProduct(largeCategoryId, -1L, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/large/{largeCategoryId}")
    public BaseResponse<ProductSliceDtoRes> userRetrieveLargeCategoryProduct(@PathVariable Long largeCategoryId, Pageable pageable) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductSliceDtoRes product = productService.retrieveLargeCategoryProduct(largeCategoryId, userId, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/non-users/products/search/{searchWord}")
    public BaseResponse<ProductSliceDtoRes> retrieveSearch(@PathVariable String searchWord, Pageable pageable) {

        try {
            ProductSliceDtoRes product = productService.retrieveSearch(searchWord, -1L, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/search/{searchWord}")
    public BaseResponse<ProductSliceDtoRes> userRetrieveSearch(@PathVariable String searchWord, Pageable pageable) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductSliceDtoRes product = productService.retrieveSearch(searchWord, userId, pageable);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/non-users/products/info/{productId}")
    public BaseResponse<ProductInfoDtoRes> retrieveProductBasic(@PathVariable Long productId) {
        try {
            ProductInfoDtoRes product = productService.retrieveProductBasic(productId, -1L);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/users/products/info/{productId}")
    public BaseResponse<ProductInfoDtoRes> userRetrieveProductBasic(@PathVariable Long productId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            ProductInfoDtoRes product = productService.retrieveProductBasic(productId, userId);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/comm-users/products/detail-info/{productId}")
    public BaseResponse<List<DetailImgDtoRes>> retrieveProductDetail(@PathVariable Long productId) {
        try {
            List<DetailImgDtoRes> product = productService.retrieveProductDetail(productId);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/comm-users/products/options/color/{productId}")
    public BaseResponse<List<ProductColorDtoRes>> retrieveProductColor(@PathVariable Long productId) {
        try {
            List<ProductColorDtoRes> product = productService.retrieveProductColor(productId);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/comm-users/products/options/size/{productId}/{colorId}")
    public BaseResponse<List<ProductSizeDtoRes>> retrieveProductSize(@PathVariable Long productId, @PathVariable Long colorId) {
        try {
            List<ProductSizeDtoRes> product = productService.retrieveProductSize(productId, colorId);
            return new BaseResponse<>(product);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}


