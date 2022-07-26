package com.ssg.ssg_be.history.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.history.dto.BrandHistoryDtoRes;
import com.ssg.ssg_be.history.dto.CategoryHistoryDtoRes;
import com.ssg.ssg_be.history.dto.SearchHistoryDtoRes;
import com.ssg.ssg_be.history.dto.ViewHistoryDto;

import java.util.List;

public interface HistoryService {
    List<ViewHistoryDto> retrieveViewHistory(Long userId) throws BaseException;

    void deleteViewHistory(Long viewHistoryId) throws BaseException;

    List<SearchHistoryDtoRes> retrieveSearchHistory(Long userId) throws BaseException;

    void deleteSearchHistory(Long searchHistoryId) throws BaseException;

    List<CategoryHistoryDtoRes> retrieveCategoryHistory(Long userId) throws BaseException;

    void deleteCategoryHistory(Long categoryHistoryId) throws BaseException;

    List<BrandHistoryDtoRes> retrieveBrandHistory(Long userId) throws BaseException;

    void deleteBrandHistory(Long brandHistoryId) throws BaseException;
}
