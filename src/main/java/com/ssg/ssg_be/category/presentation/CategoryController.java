package com.ssg.ssg_be.category.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.category.application.CategoryService;
import com.ssg.ssg_be.category.dto.CategoryDtoRes;
import com.ssg.ssg_be.category.dto.MediumCategoryDtoRes;
import com.ssg.ssg_be.category.dto.SmallCategoryDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public BaseResponse<List<CategoryDtoRes>> retrieveCategory() {

        try {
            List<CategoryDtoRes> categoryDtoRes = categoryService.retrieveCategory();
            return new BaseResponse<>(categoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/category/small/{mediumCategoryId}")
    public BaseResponse<SmallCategoryDtoRes> retrieveSmallCategory(@PathVariable Long mediumCategoryId) {

        try {
            SmallCategoryDtoRes smallCategoryDtoRes = categoryService.retrieveSmallCategory(mediumCategoryId);
            return new BaseResponse<>(smallCategoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/category/{largeCategoryId}")
    public BaseResponse<MediumCategoryDtoRes> retrieveMediumCategory(@PathVariable Long largeCategoryId) {

        try {
            MediumCategoryDtoRes mediumCategoryLists = categoryService.retrieveMediumCategory(largeCategoryId);
            return new BaseResponse<>(mediumCategoryLists);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
