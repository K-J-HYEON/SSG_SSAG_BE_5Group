package com.ssg.ssg_be.category.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.category.domain.*;
import com.ssg.ssg_be.category.infrastructure.LargeCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.MediumCategoryRepository;
import com.ssg.ssg_be.category.infrastructure.SmallCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ssg.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private LargeCategoryRepository largeCategoryRepository;
    private MediumCategoryRepository mediumCategoryRepository;
    private SmallCategoryRepository smallCategoryRepository;

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
                        .mediumCategoryList(mediumCategoryListList)
                        .build()
                );
            }

            return categoryDtoResList;

        } catch(Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public SmallCategoryDtoRes retrieveSmallCategory(Long mediumCategoryId) throws BaseException {

        try {
            MediumCategory mediumCategory = mediumCategoryRepository.getById(mediumCategoryId);

            List<SmallCategory> smallCategoryList = smallCategoryRepository.findAllByMediumCategoryMediumCategoryId(mediumCategoryId);
            List<SmallCategoryList> smallCategoryDtoResList = new ArrayList<>();

            smallCategoryList.forEach(sc -> {
                smallCategoryDtoResList.add(SmallCategoryList.builder()
                        .smallCategoryId(sc.getSmallCategoryId())
                        .smallCategoryTitle(sc.getSmallCategoryTitle())
                        .build());
            });

            return SmallCategoryDtoRes.builder()
                    .mediumCategoryId(mediumCategoryId)
                    .mediumCategoryTitle(mediumCategory.getMediumCategoryTitle())
                    .smallCategoryList(smallCategoryDtoResList)
                    .build();
        } catch(Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public MediumCategoryDtoRes retrieveMediumCategory(Long largeCategoryId) throws BaseException {

        try {
            LargeCategory largeCategory = largeCategoryRepository.getById(largeCategoryId);

            List<MediumCategory> mediumCategoryList = mediumCategoryRepository.findAllByLargeCategoryLargeCategoryId(largeCategoryId);
            List<MediumCategoryList> mediumCategoryLists = new ArrayList<>();

            mediumCategoryList.forEach(mc -> {
                mediumCategoryLists.add(MediumCategoryList.builder()
                        .mediumCategoryId(mc.getMediumCategoryId())
                        .mediumCategoryTitle(mc.getMediumCategoryTitle())
                        .build());
            });

            return MediumCategoryDtoRes.builder()
                    .largeCategoryId(largeCategoryId)
                    .largeCategoryTitle(largeCategory.getTitle())
                    .mediumCategoryList(mediumCategoryLists)
                    .build();
        } catch(Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }
}
