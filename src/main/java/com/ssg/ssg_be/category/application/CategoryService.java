package com.ssg.ssg_be.category.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.dto.CategoryDtoRes;
import com.ssg.ssg_be.category.dto.MediumCategoryDtoRes;
import com.ssg.ssg_be.category.dto.SmallCategoryDtoRes;

import java.util.List;

public interface CategoryService {

    List<CategoryDtoRes> retrieveCategory() throws BaseException;

    SmallCategoryDtoRes retrieveSmallCategory(Long mediumCategoryId) throws BaseException;

    MediumCategoryDtoRes retrieveMediumCategory(Long mediumCategoryId) throws BaseException;
}
