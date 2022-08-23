package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.domain.MainBannerDtoRes;

import java.util.List;

public interface MainBannerService {

    List<MainBannerDtoRes> retrieveMainBanner() throws BaseException;
}
