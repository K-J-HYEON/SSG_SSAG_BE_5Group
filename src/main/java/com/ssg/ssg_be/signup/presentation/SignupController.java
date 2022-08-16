package com.ssg.ssg_be.signup.presentation;


import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.signup.application.SignupService;
import com.ssg.ssg_be.signup.domain.UserDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comm-users")
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public BaseResponse<String> addUser(@RequestBody UserDtoReq userDtoReq) {
        String result = "";

        try {
            signupService.addUser(userDtoReq);
            result = "회원가입에 성공했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
