package com.ssg.ssg_be.login.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.login.application.SellerLoginService;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellers")
public class SellerLoginController {

    private final SellerLoginService sellerLoginService;

    @Autowired
    public SellerLoginController(SellerLoginService sellerLoginService) {
        this.sellerLoginService = sellerLoginService;
    }

    @PostMapping("/login")
    public BaseResponse<String> sellerLogin(@RequestBody LoginDtoReq loginDtoReq) {
        String token = "";

        try {
            token = sellerLoginService.sellerLogin(loginDtoReq);
            return new BaseResponse<>(token);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
        
    }
}
