package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.domain.MainBanner;
import com.ssg.ssg_be.mainpage.domain.MainBannerDtoRes;
import com.ssg.ssg_be.mainpage.infrastructure.MainBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class MainBannerServiceImpl implements MainBannerService {

    private final MainBannerRepository mainBannerRepository;

    @Autowired
    public MainBannerServiceImpl(MainBannerRepository mainBannerRepository) {
        this.mainBannerRepository = mainBannerRepository;
    }

    @Override
    public List<MainBannerDtoRes> retrieveMainBanner() throws BaseException {

        try {
            List<MainBanner> mainBanners = mainBannerRepository.findAllByOrderByPriority();
            List<MainBannerDtoRes> mainBannerDtoRes = new ArrayList<>();

            mainBanners.forEach(mainBanner -> mainBannerDtoRes.add(MainBannerDtoRes.builder()
                    .mainBannerId(mainBanner.getMainBannerId())
                    .originName(mainBanner.getOriginName())
                    .saveName(mainBanner.getSaveName())
                    .imgUrl(mainBanner.getImgUrl())
                    .priority(mainBanner.getPriority())
                    .build())
            );

            return mainBannerDtoRes;
        } catch (Exception exception) {
            throw new BaseException(BANNER_RETRIEVE_FAILED);
        }

    }
}
