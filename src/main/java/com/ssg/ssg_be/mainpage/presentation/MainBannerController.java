package com.ssg.ssg_be.mainpage.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.mainpage.application.MainBannerService;
import com.ssg.ssg_be.mainpage.domain.MainBannerDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm-users")
public class MainBannerController {

    private final MainBannerService mainBannerService;

    @Autowired
    public MainBannerController(MainBannerService mainBannerService) {
        this.mainBannerService = mainBannerService;
    }

    @ResponseBody
    @GetMapping("/main-banner")
    public BaseResponse<List<MainBannerDtoRes>> retrieveMainBanner() {

        try {
            List<MainBannerDtoRes> mainBannerDtoRes = mainBannerService.retrieveMainBanner();
            return new BaseResponse<>(mainBannerDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
