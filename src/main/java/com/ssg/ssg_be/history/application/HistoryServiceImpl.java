package com.ssg.ssg_be.history.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.history.domain.*;
import com.ssg.ssg_be.history.infrastructure.BrandHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.CategoryHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.SearchHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.ViewHistoryRepository;
import com.ssg.ssg_be.signup.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Slf4j
@Service
public class HistoryServiceImpl implements HistoryService {
    private final BrandHistoryRepository brandHistoryRepository;
    private final CategoryHistoryRepository categoryHistoryRepository;
    private final ViewHistoryRepository viewHistoryRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    public HistoryServiceImpl(BrandHistoryRepository brandHistoryRepository, CategoryHistoryRepository categoryHistoryRepository, ViewHistoryRepository viewHistoryRepository, SearchHistoryRepository searchHistoryRepository) {
        this.brandHistoryRepository = brandHistoryRepository;
        this.categoryHistoryRepository = categoryHistoryRepository;
        this.viewHistoryRepository = viewHistoryRepository;
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public List<ViewHistoryDtoRes> retrieveViewHistory(Long userId) throws BaseException {
        try {
            return viewHistoryRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(VIEWHISTORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteViewHistory(Long viewHistoryId) throws BaseException {
        try {
            viewHistoryRepository.deleteById(viewHistoryId);
        } catch (Exception exception) {
            throw new BaseException(VIEWHISTORY_DELETE_FAILED);
        }
    }

    @Override
    public List<SearchHistoryDtoRes> retrieveSearchHistory(Long userId) throws BaseException {
        try {
            return searchHistoryRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(SEARCHHISTORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteSearchHistory(Long searchHistoryId) throws BaseException {
        try {
            searchHistoryRepository.deleteById(searchHistoryId);
        } catch (Exception exception) {
            throw new BaseException(SEARCHHISTORY_DELETE_FAILED);
        }
    }

    @Override
    public List<CategoryHistoryDtoRes> retrieveCategoryHistory(Long userId) throws BaseException {
        try {
            return categoryHistoryRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(CATEGORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteCategoryHistory(Long categoryHistoryID) throws BaseException {
        try {
            categoryHistoryRepository.deleteById(categoryHistoryID);
        } catch (Exception exception) {
            throw new BaseException(CATEGORYHISTORY_DELETE_FAILED);
        }
    }

    // brand는 따로 조회 & 삭제 구현 => 삽입 미완성
    @Override
    public List<BrandHistoryDtoRes> retrieveBrandHistory(Long userId) throws BaseException {
        try {
            return brandHistoryRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(BRANDHISTORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteBrandHistory(Long brandHistoryId) throws BaseException {
        try {
            brandHistoryRepository.deleteById(brandHistoryId);
        } catch (Exception exception) {
            throw new BaseException(BRANDHISTORY_RETRIEVE_FAILED);
        }
    }
}
