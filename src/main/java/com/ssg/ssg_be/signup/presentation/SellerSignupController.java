package com.ssg.ssg_be.signup.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.signup.application.SellerSignupService;
import com.ssg.ssg_be.signup.domain.SellerDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellers")
public class SellerSignupController {

    private final SellerSignupService sellerSignupService;

    @Autowired
    public SellerSignupController(SellerSignupService sellerSignupService) {
        this.sellerSignupService = sellerSignupService;
    }

    @PostMapping("/signup")
    private BaseResponse<String> addSeller(@RequestBody SellerDtoReq sellerDtoReq) {
        String result = "";

        try {
            sellerSignupService.addSeller(sellerDtoReq);
            result = "회원가입에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
