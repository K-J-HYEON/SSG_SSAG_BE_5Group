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
        try {
            sellerRepository.save(sellerDtoReq.toEntity());
        } catch (Exception exception) {
            throw new BaseException(SELLER_INSERT_FAILED);
        }
    }

}
