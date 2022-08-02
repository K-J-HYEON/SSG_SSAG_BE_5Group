package com.ssg.ssg_be.signup.application;

import com.ssg.ssg_be.signup.infrastucture.MarketingRepository;
import com.ssg.ssg_be.signup.infrastucture.SellerRepository;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl {

    private final UserRepository userRepository;
    private final MarketingRepository marketingRepository;
    private final SellerRepository sellerRepository;

    public SignupServiceImpl(UserRepository userRepository, MarketingRepository marketingRepository, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.marketingRepository = marketingRepository;
        this.sellerRepository = sellerRepository;
    }


}
