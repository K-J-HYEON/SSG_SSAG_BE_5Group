package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    //private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void userLogin(LoginDtoReq loginDtoReq) throws BaseException {

        try {

        } catch (Exception exception) {
            throw new BaseException(LOGIN_FAILED);
        }
    }
}
