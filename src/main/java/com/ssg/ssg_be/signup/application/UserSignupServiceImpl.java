package com.ssg.ssg_be.signup.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.domain.UserDtoReq;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class UserSignupServiceImpl implements UserSignupService {

    private final UserRepository userRepository;

    @Autowired
    public UserSignupServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserDtoReq userDtoReq) throws BaseException {
        try {
            userRepository.save(userDtoReq.toEntity());
        } catch (Exception exception) {
            throw new BaseException(USER_INSERT_FAILED);
        }
    }
}
