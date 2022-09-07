package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.dto.*;

import java.util.List;

public interface MainService {

    List<MainBannerDtoRes> retrieveMainBanner() throws BaseException;

    List<HappyLoungeDtoRes> retrieveHappyLounge() throws BaseException;

    List<NewServiceDtoRes> retrieveNewService() throws BaseException;

    List<CardPromotionDtoRes> retrieveCardPromotion() throws BaseException;

    List<HotBrandDtoRes> retrieveHotBrand() throws BaseException;
}
