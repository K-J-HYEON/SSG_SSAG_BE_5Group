package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.config.Role;
import com.ssg.ssg_be.login.dto.LoginDtoReq;
import com.ssg.ssg_be.login.dto.LoginUserDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.utils.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.ssg.config.BaseResponseStatus.*;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String userLogin(LoginDtoReq loginDtoReq) throws BaseException {

        User user = userRepository.findByLoginId(loginDtoReq.getLoginId()).orElseThrow(() -> new BaseException(FAILED_TO_LOGIN));

        long datetime = System.currentTimeMillis();
        Timestamp newDate = new Timestamp(datetime);

        if (bCryptPasswordEncoder.matches(loginDtoReq.getLoginPwd(), user.getLoginPwd())) {
            try {
                try {
                    LoginUserDtoReq loginUserDtoReq = new LoginUserDtoReq(newDate);
                    userRepository.save(loginUserDtoReq.toEntity(user));
                } catch (Exception exception) {
                    throw new BaseException(DATABASE_ERROR);
                }
                return jwtTokenProvider.createToken(user.getUserId(), String.valueOf(Role.USER));
            } catch (Exception exception) {
                throw new BaseException(JWT_CREATE_FAILED);
            }
        } else {
            throw new BaseException(FAILED_TO_LOGIN);
        }
    }
}
