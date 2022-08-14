package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.config.Role;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserLoginServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String userLogin(LoginDtoReq loginDtoReq) throws BaseException {

        User user = userRepository.findByLoginId(loginDtoReq.getLoginId());

        if (bCryptPasswordEncoder.matches(loginDtoReq.getLoginPwd(), user.getLoginPwd())) {
            try {
                return jwtTokenProvider.createToken(user.getUserId(), String.valueOf(Role.USER));
            } catch (Exception exception) {
                throw new BaseException(JWT_CREATE_FAILED);
            }
        } else {
            throw new BaseException(LOGIN_FAILED);
        }
    }
}
