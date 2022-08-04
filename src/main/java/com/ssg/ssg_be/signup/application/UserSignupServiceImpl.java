package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.MarketingDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.domain.UserDtoReq;
import com.ssg.ssg_be.signup.infrastucture.MarketingRepository;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        // 아이디 중복 검사
        if(userRepository.existsByLoginId(userDtoReq.getLoginId())) {
            throw new BaseException(POST_EXISTS_LOGIN_ID);
        }

        System.out.println();

        // 이메일 중복 검사
        if(userRepository.existsByEmail(userDtoReq.getEmail())) {
            throw new BaseException(POST_EXISTS_EMAIL);
        }

        // 휴대폰 번호 중복 검사
        if(userRepository.existsByPhone(userDtoReq.getPhone())) {
            throw new BaseException(POST_EXISTS_PHONE);
        }

        User user = userDtoReq.toEntity();

        try {
            userRepository.save(user);
        } catch (Exception exception) {
            throw new BaseException(USER_INSERT_FAILED);
        }

        MarketingDtoReq marketingDtoReq = new MarketingDtoReq(user, userDtoReq.getMarketing1(), userDtoReq.getUpdateAt1(), userDtoReq.getMarketing2(), userDtoReq.getUpdateAt2(), userDtoReq.getMarketing3(), userDtoReq.getUpdateAt3());

        try {
            marketingRepository.save(marketingDtoReq.toMarketingEntity());
        } catch (Exception exception) {
            throw new BaseException(USER_INSERT_FAILED);
        }
    }
}
