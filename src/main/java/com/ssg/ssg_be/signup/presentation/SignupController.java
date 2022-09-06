package com.ssg.ssg_be.signup.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.review.infrastructure.ReviewRepository;
import com.ssg.ssg_be.signup.application.SignupService;
import com.ssg.ssg_be.signup.dto.UserDtoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comm-users")
public class SignupController {

    private SignupService signupService;
    private ReviewRepository reviewRepository;

    @Autowired
    public SignupController(SignupService signupService, ReviewRepository reviewRepository) {
        this.signupService = signupService;
        this.reviewRepository = reviewRepository;
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

    @GetMapping("/signup/overlap/{checkId}")
    public BaseResponse<String> checkUserId(@PathVariable String checkId) {
        String result = "";

        try {
            signupService.checkUserId(checkId);
            result = "사용할 수 있는 아이디입니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
