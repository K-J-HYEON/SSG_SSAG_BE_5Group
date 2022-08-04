package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.SellerDtoReq;
import com.ssg.ssg_be.signup.infrastucture.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class SellerSignupServiceImpl implements SellerSignupService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerSignupServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void addSeller(SellerDtoReq sellerDtoReq) throws BaseException {

        // 아이디 중복 검사
        if(sellerRepository.existsByLoginId(sellerDtoReq.getLoginId())) {
            throw new BaseException(POST_EXISTS_LOGIN_ID);
        }

        // 휴대폰 번호 중복 검사
        if(sellerRepository.existsByPhone(sellerDtoReq.getPhone())) {
            throw new BaseException(POST_EXISTS_PHONE);
        }

        // 법인 번호 중복 검사
        if(sellerRepository.existsByCorporationNumber(sellerDtoReq.getCorporationNumber())) {
            throw new BaseException(POST_SELLERS_EXISTS_CORPORATION_NUM);
        }

        try {
            sellerRepository.save(sellerDtoReq.toEntity());
        } catch (Exception exception) {
            throw new BaseException(SELLER_INSERT_FAILED);
        }
    }

}
