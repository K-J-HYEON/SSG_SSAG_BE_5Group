package com.ssg.ssg_be.mainpage.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.mainpage.application.MainService;
import com.ssg.ssg_be.mainpage.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/main-banner")
    public BaseResponse<List<MainBannerDtoRes>> retrieveMainBanner() {

        try {
            List<MainBannerDtoRes> mainBannerDtoRes = mainService.retrieveMainBanner();
            return new BaseResponse<>(mainBannerDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/main/happy-lounge")
    public BaseResponse<List<HappyLoungeDtoRes>> retrieveHappyLounge() {

        try {
            List<HappyLoungeDtoRes> happyLoungeDtoRes = mainService.retrieveHappyLounge();
            return new BaseResponse<>(happyLoungeDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/main/new-service")
    public BaseResponse<List<NewServiceDtoRes>> retrieveNewService() {

        try {
            List<NewServiceDtoRes> newServiceDtoRes = mainService.retrieveNewService();
            return new BaseResponse<>(newServiceDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/main/card-promotion")
    public BaseResponse<List<CardPromotionDtoRes>> retrieveCardPromotion() {

        try {
            List<CardPromotionDtoRes> cardPromotionDtoRes = mainService.retrieveCardPromotion();
            return new BaseResponse<>(cardPromotionDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/main/hot-brand")
    public BaseResponse<List<HotBrandDtoRes>> retrieveHotBrand() {

        try {
            List<HotBrandDtoRes> hotBrandDtoRes = mainService.retrieveHotBrand();
            return new BaseResponse<>(hotBrandDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
