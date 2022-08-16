package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.CartPatchDtoReq;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoReq;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoRes;
import com.ssg.ssg_be.signup.domain.Seller;
import com.ssg.ssg_be.signup.infrastucture.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class SellerMemberInfoServiceImpl implements SellerMemberInfoService {

    private SellerRepository sellerRepository;

    @Autowired
    public SellerMemberInfoServiceImpl(SellerRepository sellerRepository) { this.sellerRepository = sellerRepository; }

    @Override
    public SellerMemberInfoDtoRes retrieveSellerMember(Long sellerId) throws BaseException {

        try {
            return sellerRepository.findById(sellerId).get().toDto();
        } catch (Exception exception) {
            throw new BaseException(SELLER_RETRIEVE_FAILED);
        }
    }

    @Override
    public void updateSellerInfo(SellerMemberInfoDtoReq sellerMemberInfoDtoReq) throws BaseException {

    }

//    @Override
//    public void updateSellerInfo(SellerMemberInfoDtoReq sellerMemberInfoDtoReq) throws BaseException {
//        try {
//            Seller seller = sellerRepository.getById(sellerMemberInfoDtoReq.getNewPassword());
//        } catch (Exception exception) {
//            throw new BaseException(SELLERINFO_UPDATE_FAILED);
//        }
//    }
}
