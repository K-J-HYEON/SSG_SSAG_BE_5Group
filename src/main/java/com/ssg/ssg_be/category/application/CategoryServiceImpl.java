package com.ssg.ssg_be.category.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.domain.*;
import com.ssg.ssg_be.category.infrastructure.LargeCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.MediumCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.SmallCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final LargeCategoryRepository largeCategoryRepository;
    private final MediumCategoryRepository mediumCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;

    @Autowired
    public CategoryServiceImpl(LargeCategoryRepository largeCategoryRepository, MediumCategoryRepository mediumCategoryRepository, SmallCategoryRepository smallCategoryRepository) {
        this.largeCategoryRepository = largeCategoryRepository;
        this.mediumCategoryRepository = mediumCategoryRepository;
        this.smallCategoryRepository = smallCategoryRepository;
    }

    @Override
    public List<CategoryDtoRes> retrieveCategory() throws BaseException {

        try {
            List<LargeCategory> largeCategories = largeCategoryRepository.findAll();
            List<MediumCategory> mediumCategories = mediumCategoryRepository.findAll();

            List<CategoryDtoRes> categoryDtoResList = new ArrayList<>();
            List<MediumCategoryList> mediumCategoryListList;

            for (LargeCategory lc : largeCategories) {
                mediumCategoryListList = new ArrayList<>();

                for (MediumCategory mc : mediumCategories) {
                    if(Objects.equals(mc.getLargeCategory().getLargeCategoryId(), lc.getLargeCategoryId())) {
                        mediumCategoryListList.add(MediumCategoryList.builder()
                                .mediumCategoryId(mc.getMediumCategoryId())
                                .mediumCategoryTitle(mc.getMediumCategoryTitle())
                                .build());
                    }
                }

                categoryDtoResList.add(CategoryDtoRes.builder()
                        .largeCategoryId(lc.getLargeCategoryId())
                        .title(lc.getTitle())
                        .mediumCategoryDtoRes(mediumCategoryListList)
                        .build()
                );
            }

            return categoryDtoResList;

        } catch(Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<SmallCategoryDtoRes> retrieveSmallCategory(Long mediumCategoryId) throws BaseException {

        try {
            List<SmallCategory> smallCategoryList = smallCategoryRepository.findAllByMediumCategoryMediumCategoryId(mediumCategoryId);
            List<SmallCategoryDtoRes> smallCategoryDtoResList = new ArrayList<>();

            smallCategoryList.forEach(sc -> {
                smallCategoryDtoResList.add(SmallCategoryDtoRes.builder()
                        .smallCategoryId(sc.getSmallCategoryId())
                        .smallCategoryTitle(sc.getSmallCategoryTitle())
                        .build());
            });

            return smallCategoryDtoResList;
        } catch(Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }
}
