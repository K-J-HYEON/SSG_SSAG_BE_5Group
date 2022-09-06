package com.ssg.ssg_be.history.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.history.application.HistoryService;
import com.ssg.ssg_be.history.dto.BrandHistoryDtoRes;
import com.ssg.ssg_be.history.dto.CategoryHistoryDtoRes;
import com.ssg.ssg_be.history.dto.SearchHistoryDtoRes;
import com.ssg.ssg_be.history.dto.ViewHistoryDto;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class HistoryController {

    private final HistoryService historyService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public HistoryController(HistoryService historyService, JwtTokenProvider jwtTokenProvider) {
        this.historyService = historyService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/recent/product")
    public BaseResponse<List<ViewHistoryDto>> retrieveViewHistory() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ViewHistoryDto> viewHistoryDtoRes = historyService.retrieveViewHistory(userId);
            return new BaseResponse<>(viewHistoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/recent/product/{viewHistoryId}")
    public BaseResponse<String> deleteViewHistory(@PathVariable Long viewHistoryId) {
        String result = "";

        try {
            historyService.deleteViewHistory(viewHistoryId);
            result = "최근 본 상품 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/recent/search")
    public BaseResponse<List<SearchHistoryDtoRes>> retrieveSearchHistory() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<SearchHistoryDtoRes> searchHistoryDtoRes = historyService.retrieveSearchHistory(userId);
            return new BaseResponse<>(searchHistoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/recent/search/{searchId}")
    public BaseResponse<String> deleteSearchHistory(@PathVariable Long searchId) {
        String result = "";

        try {
            historyService.deleteSearchHistory(searchId);
            result = "최근 본 상품검색 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("recent/category")
    public BaseResponse<List<CategoryHistoryDtoRes>> retrieveCategoryHistory() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<CategoryHistoryDtoRes> categoryHistoryDtoRes = historyService.retrieveCategoryHistory(userId);
            return new BaseResponse<>(categoryHistoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/recent/category/{categoryId}")
    public BaseResponse<String> deleteCategoryHistory(@PathVariable Long categoryId) {
        String result = "";

        try {
            historyService.deleteCategoryHistory(categoryId);
            result = "최근 본 카테고리 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/recent/brand")
    public BaseResponse<List<BrandHistoryDtoRes>> retrieveBrandHistory() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<BrandHistoryDtoRes> brandHistoryDtoRes = historyService.retrieveBrandHistory(userId);
            return new BaseResponse<>(brandHistoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/recent/brand/{brandId}")
    public BaseResponse<String> deleteBrandHistory(@PathVariable Long brandId) {
        String result = "";

        try {
            historyService.deleteBrandHistory(brandId);
            result = "최근 본 브랜드 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        }  catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
