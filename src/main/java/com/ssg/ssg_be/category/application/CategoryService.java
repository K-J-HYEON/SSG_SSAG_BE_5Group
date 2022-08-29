package com.ssg.ssg_be.category.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.domain.CategoryDtoRes;
import com.ssg.ssg_be.category.domain.MediumCategoryList;
import com.ssg.ssg_be.category.domain.SmallCategoryDtoRes;

import java.util.List;

public interface CategoryService {

    List<CategoryDtoRes> retrieveCategory() throws BaseException;
    List<SmallCategoryDtoRes> retrieveSmallCategory(Long mediumCategoryId) throws BaseException;
    List<MediumCategoryList> retrieveMediumCategory(Long mediumCategoryId) throws BaseException;
}
