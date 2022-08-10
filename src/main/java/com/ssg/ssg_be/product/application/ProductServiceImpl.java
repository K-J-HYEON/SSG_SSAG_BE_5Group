package com.ssg.ssg_be.product.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.infrastructure.CategoryConnRepository;
import com.ssg.ssg_be.product.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.SEARCH_RETRIEVE_FAILED;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryConnRepository categoryConnRepository;

    @Autowired
    public ProductServiceImpl(CategoryConnRepository categoryConnRepository) {
        this.categoryConnRepository = categoryConnRepository;
    }

    @Override
    public List<CategoryProductDtoRes> retrieveMediumCategoryProduct(Long mediumCategoryId) throws BaseException {

        try {
            return categoryConnRepository.findByMediumCategoryId(mediumCategoryId);
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<CategoryProductDtoRes> retrieveSmallCategoryProduct(Long smallCategoryId) throws BaseException {

        try {
            return categoryConnRepository.findBySmallCategorySmallCategoryId(smallCategoryId);
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<CategoryProductDtoRes> retrieveLargeCategoryProduct(Long largeCategoryId) throws BaseException {

        try {
            return categoryConnRepository.findByLargeCategoryId(largeCategoryId);
        } catch(Exception exception) {
            throw new BaseException(SEARCH_RETRIEVE_FAILED);
        }
    }

}
