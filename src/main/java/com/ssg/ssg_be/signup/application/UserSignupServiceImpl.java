package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.MarketingDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.domain.UserDtoReq;
import com.ssg.ssg_be.signup.infrastucture.MarketingRepository;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class UserSignupServiceImpl implements UserSignupService {

    private final UserRepository userRepository;

    private final MarketingRepository marketingRepository;

    @Autowired
    public UserSignupServiceImpl(UserRepository userRepository, MarketingRepository marketingRepository) {
        this.userRepository = userRepository;
        this.marketingRepository = marketingRepository;
    }

    @Override
    public void addUser(UserDtoReq userDtoReq) throws BaseException {

        User user = userDtoReq.toEntity();

        try {
            userRepository.save(user);
        } catch (Exception exception) {
            throw new BaseException(USER_INSERT_FAILED);
        }

        System.out.println(userDtoReq.getMarketing1());
        System.out.println(userDtoReq.getUpdateAt1());

        MarketingDtoReq marketingDtoReq = new MarketingDtoReq(user, userDtoReq.getMarketing1(), userDtoReq.getUpdateAt1(), userDtoReq.getMarketing2(), userDtoReq.getUpdateAt2(), userDtoReq.getMarketing3(), userDtoReq.getUpdateAt3());

        try {
            marketingRepository.save(marketingDtoReq.toMarketingEntity());
        } catch (Exception exception) {
            throw new BaseException(USER_INSERT_FAILED);
        }
    }
}
