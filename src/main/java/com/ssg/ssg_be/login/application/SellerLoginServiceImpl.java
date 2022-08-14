package com.ssg.ssg_be.login.application;

import com.ssg.config.BaseException;
import com.ssg.config.Role;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import com.ssg.ssg_be.signup.domain.Seller;
import com.ssg.ssg_be.signup.infrastucture.SellerRepository;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class SellerLoginServiceImpl implements SellerLoginService {

    private final SellerRepository sellerRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SellerLoginServiceImpl(SellerRepository sellerRepository, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.sellerRepository = sellerRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String sellerLogin(LoginDtoReq loginDtoReq) throws BaseException {

        Seller seller = sellerRepository.findByLoginId(loginDtoReq.getLoginId());

        if (bCryptPasswordEncoder.matches(loginDtoReq.getLoginPwd(), seller.getLoginPwd())) {
            try {
                return jwtTokenProvider.createToken(seller.getSellerId(), String.valueOf(Role.SELLER));
            } catch (Exception exception) {
                throw new BaseException(JWT_CREATE_FAILED);
            }
        } else {
            throw new BaseException(LOGIN_FAILED);
        }
    }
}
