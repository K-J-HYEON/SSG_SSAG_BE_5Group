package com.ssg.ssg_be.review.presentation;


import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.review.application.ReviewService;
import com.ssg.ssg_be.review.domain.ReviewDtoReq;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class reviewController {

    private final ReviewService reviewService;
    private final JwtTokenProvider jwtTokenProvider;



    @Autowired
    public reviewController(ReviewService reviewService, JwtTokenProvider jwtTokenProvider) {
        this.reviewService = reviewService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/review")
    public BaseResponse<String> addReview(@RequestBody ReviewDtoReq reviewDtoReq) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));
        String result = "";

        try {
            reviewService.createReview(reviewDtoReq);
            result = "리뷰 생성에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }



}
