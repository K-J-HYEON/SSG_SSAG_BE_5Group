package com.ssg.ssg_be.mainpage.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.mainpage.domain.*;
import com.ssg.ssg_be.mainpage.dto.*;
import com.ssg.ssg_be.mainpage.infrastructure.*;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.domain.ThumbnailImg;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.product.infrastructure.ThumbnailImgRepository;
import lombok.RequiredArgsConstructor;
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
    private final NewServiceRepository newServiceRepository;
    private final CardPromotionRepository cardPromotionRepository;
    private final HotBrandRepository hotBrandRepository;

    @Autowired
    public MainServiceImpl(MainBannerRepository mainBannerRepository, HappyLoungeRepository happyLoungeRepository, ProductRepository productRepository, ThumbnailImgRepository thumbnailImgRepository, NewServiceRepository newServiceRepository, CardPromotionRepository cardPromotionRepository, HotBrandRepository hotBrandRepository) {
        this.mainBannerRepository = mainBannerRepository;
        this.happyLoungeRepository = happyLoungeRepository;
        this.productRepository = productRepository;
        this.thumbnailImgRepository = thumbnailImgRepository;
        this.newServiceRepository = newServiceRepository;
        this.cardPromotionRepository = cardPromotionRepository;
        this.hotBrandRepository = hotBrandRepository;
    }

    @Override
    public List<MainBannerDtoRes> retrieveMainBanner() throws BaseException {

        try {
            List<MainBanner> mainBanners = mainBannerRepository.findAllByOrderByPriority();
            List<MainBannerDtoRes> mainBannerDtoRes = new ArrayList<>();

            mainBanners.forEach(mainBanner -> mainBannerDtoRes.add(MainBannerDtoRes.builder()
                    .mainBannerId(mainBanner.getMainBannerId())
                    .title(mainBanner.getTitle())
                    .content(mainBanner.getContent())
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
            for (HappyLounge h : happyLounges) {
                if (i >= size || i >= 3) {
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

    @Override
    public List<NewServiceDtoRes> retrieveNewService() throws BaseException {
        try {
            List<NewServiceDtoRes> newServiceDtoRes = new ArrayList<>();
            List<NewService> newServices = newServiceRepository.findAllByOrderByPriority();

            newServices.forEach(newService -> newServiceDtoRes.add(NewServiceDtoRes.builder()
                    .newServiceId(newService.getNewServiceId())
                    .title(newService.getTitle())
                    .subTitle(newService.getSubTitle())
                    .originName(newService.getOriginName())
                    .saveName(newService.getSaveName())
                    .imgUrl(newService.getImgUrl())
                    .priority(newService.getPriority())
                    .build())
            );

            return newServiceDtoRes;
        } catch (Exception exception) {
            throw new BaseException(NEW_SERVICE_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<CardPromotionDtoRes> retrieveCardPromotion() throws BaseException {
        try {
            List<CardPromotionDtoRes> cardPromotionDtoRes = new ArrayList<>();
            List<CardPromotion> cardPromotions = cardPromotionRepository.findAll();

            cardPromotions.forEach(cardPromotion -> cardPromotionDtoRes.add(CardPromotionDtoRes.builder()
                    .cardPromotionId(cardPromotion.getCardPromotionId())
                    .cardName(cardPromotion.getCardName())
                    .event(cardPromotion.getEvent())
                    .benefits(cardPromotion.getBenefits())
                    .tagImgUrl(cardPromotion.getTagImgUrl())
                    .build()));

            return cardPromotionDtoRes;
        } catch (Exception exception) {
            throw new BaseException(CARD_PROMOTION_RETRIEVE_FAILED);
        }
    }

    @Override
    public List<HotBrandDtoRes> retrieveHotBrand() throws BaseException {
        try {
            List<HotBrandDtoRes> hotBrandDtoRes = new ArrayList<>();
            List<HotBrand> hotBrands = hotBrandRepository.findAllByOrderByPriority();

            hotBrands.forEach(hotBrand -> hotBrandDtoRes.add(HotBrandDtoRes.builder()
                    .hotBrandId(hotBrand.getHotBrandId())
                    .brandName(hotBrand.getBrandName())
                    .imgUrl(hotBrand.getImgUrl())
                    .priority(hotBrand.getPriority())
                    .build()));

            return hotBrandDtoRes;
        } catch (Exception exception) {
            throw new BaseException(HOT_BRAND_RETRIEVE_FAILED);
        }
    }
}
