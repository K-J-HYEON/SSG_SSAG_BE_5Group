package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoRes;
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
}
