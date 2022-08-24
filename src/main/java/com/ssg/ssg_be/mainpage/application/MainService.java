package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.domain.HappyLoungeDtoRes;
import com.ssg.ssg_be.mainpage.domain.MainBannerDtoRes;
import com.ssg.ssg_be.mainpage.domain.NewServiceDtoRes;

import java.util.List;

public interface MainService {

    List<MainBannerDtoRes> retrieveMainBanner() throws BaseException;
    List<HappyLoungeDtoRes> retrieveHappyLounge() throws BaseException;
    List<NewServiceDtoRes> retrieveNewService() throws BaseException;
}
