package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.domain.*;
import com.ssg.ssg_be.mainpage.infrastructure.HappyLoungeRepository;
import com.ssg.ssg_be.mainpage.infrastructure.MainBannerRepository;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ThumbnailImg;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.product.infrastructure.ThumbnailImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class MainServiceImpl implements MainService {

    private final MainBannerRepository mainBannerRepository;
    private final HappyLoungeRepository happyLoungeRepository;
    private final ProductRepository productRepository;
    private final ThumbnailImgRepository thumbnailImgRepository;

    @Autowired
    public MainServiceImpl(MainBannerRepository mainBannerRepository, HappyLoungeRepository happyLoungeRepository, ProductRepository productRepository, ThumbnailImgRepository thumbnailImgRepository) {
        this.mainBannerRepository = mainBannerRepository;
        this.happyLoungeRepository = happyLoungeRepository;
        this.productRepository = productRepository;
        this.thumbnailImgRepository = thumbnailImgRepository;
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

    @Override
    public List<HappyLoungeDtoRes> retrieveHappyLounge() throws BaseException {
        try {
            List<HappyLounge> happyLounges = happyLoungeRepository.findAll();
            List<HappyLoungeDtoRes> happyLoungeDtoRes = new ArrayList<>();

            int i = 0, size = happyLounges.size();
            for(HappyLounge h : happyLounges) {
                if(i >= size || i >=3) {
                    break;
                }
                i++;

                Product product = productRepository.getById(h.getProductId());
                List<ThumbnailImg> thumbnailImg = thumbnailImgRepository.findAllByProductProductIdOrderByPriority(product.getProductId());
                List<HappyLoungeImgDto> happyLoungeImgDtos = new ArrayList<>();
                thumbnailImg.forEach(ti -> happyLoungeImgDtos.add(HappyLoungeImgDto.builder()
                                .thumbnailImgId(ti.getThumbnailImgId())
                                .originName(ti.getOriginName())
                                .saveName(ti.getSaveName())
                                .imgUrl(ti.getImgUrl())
                                .priority(ti.getPriority())
                        .build())
                );

                happyLoungeDtoRes.add(HappyLoungeDtoRes.builder()
                                .productId(product.getProductId())
                                .name(product.getName())
                                .price(product.getPrice())
                                .sale(product.getSale())
                                .saleStartDate(product.getSaleStartDate())
                                .saleEndDate(product.getSaleEndDate())
                                .imgOriginName(product.getImgOriginName())
                                .imgSaveName(product.getImgSaveName())
                                .imgUrl(product.getImgUrl())
                                .happyLoungeImgDto(happyLoungeImgDtos)
                        .build());
            }

            return happyLoungeDtoRes;
        } catch (Exception exception) {
            throw new BaseException(HAPPY_LOUNGE_RETRIEVE_FAILED);
        }
    }
}
