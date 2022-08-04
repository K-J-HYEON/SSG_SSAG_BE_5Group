package com.ssg.ssg_be.signup.presentation;


import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.signup.application.UserSignupService;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.domain.UserDtoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserSignupController {

    private final UserSignupService userSignupService;

    @Autowired
    public UserSignupController(UserSignupService userSignupService) {
        this.userSignupService = userSignupService;
    }

    @PostMapping("/signup")
    private BaseResponse<String> addUser(@RequestBody UserDtoReq userDtoReq) {
        String result = "";

        try {
            userSignupService.addUser(userDtoReq);
            result = "회원가입에 성공했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
