package com.ssg.ssg_be.category.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.category.application.CategoryService;
import com.ssg.ssg_be.category.domain.CategoryDtoRes;
import com.ssg.ssg_be.category.domain.SmallCategoryDtoRes;
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

    @ResponseBody
    @GetMapping("/category")
    public BaseResponse<List<CategoryDtoRes>> retrieveCategory() {

        try {
            List<CategoryDtoRes> categoryDtoRes = categoryService.retrieveCategory();
            return new BaseResponse<>(categoryDtoRes);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/category/small/{mediumCategoryId}")
    public BaseResponse<List<SmallCategoryDtoRes>> retrieveSmallCategory(@PathVariable Long mediumCategoryId) {

        try {
            List<SmallCategoryDtoRes> smallCategoryDtoRes = categoryService.retrieveSmallCategory(mediumCategoryId);
            return new BaseResponse<>(smallCategoryDtoRes);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
