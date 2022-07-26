package com.ssg.ssg_be.review.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.review.application.ReviewService;
import com.ssg.ssg_be.review.dto.ReviewDtoReq;
import com.ssg.ssg_be.review.dto.ReviewDtoRes;
import com.ssg.ssg_be.review.dto.ReviewPatchDtoReq;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ReviewController {

    private final ReviewService reviewService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ReviewController(ReviewService reviewService, JwtTokenProvider jwtTokenProvider) {
        this.reviewService = reviewService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/review")
    public BaseResponse<String> addReview(@RequestPart(value = "reviewImg") List<MultipartFile> reviewImg,
                                          @RequestPart(value = "reviewDto") ReviewDtoReq reviewDto) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));
        String result;

        try {
            reviewService.createReview(reviewDto, userId, reviewImg);
            result = "리뷰 생성에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/review/{reviewId}")
    public BaseResponse<List<ReviewDtoRes>> retrieveReview(@PathVariable Long reviewId) {
        try {
            List<ReviewDtoRes> reviewDtoRes = reviewService.retrieveReview(reviewId);
            return new BaseResponse<>(reviewDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/review/user")
    public BaseResponse<List<ReviewDtoRes>> retrieveMyReview() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<ReviewDtoRes> reviewDtoRes = reviewService.retrieveMyReview(userId);
            return new BaseResponse<>(reviewDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/review/{reviewId}")
    public BaseResponse<String> deleteReview(@PathVariable Long reviewId) {
        String result = "";

        try {
            reviewService.deleteReview(reviewId);
            result = "리뷰를 삭제했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/review")
    public BaseResponse<String> updateReview(@RequestBody ReviewPatchDtoReq reviewPatchDtoReq) {
        String result = "";

        try {
            reviewService.updateReview(reviewPatchDtoReq);
            result = "리뷰를 수정했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
