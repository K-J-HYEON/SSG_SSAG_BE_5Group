package com.ssg.ssg_be.history.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.history.application.HistoryService;
import com.ssg.ssg_be.history.domain.ViewHistoryDtoRes;
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

    @ResponseBody
    @GetMapping("/recent/product")
    public BaseResponse<List<ViewHistoryDtoRes>> retrieveViewHistory() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ViewHistoryDtoRes> viewHistoryDtoRes = historyService.retrieveViewHistory(userId);
            return new BaseResponse<>(viewHistoryDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/recent/product")
    public BaseResponse<String> deleteViewHistory(Long productId) {
        String result = "";

        try {
            historyService.deleteViewHistory(productId);
            result = "최근 본 상품 내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

//    @ResponseBody
//    @GetMapping("/recent/category")



//    @ResponseBody
//    @DeleteMapping("/recent/catrgory")

}
