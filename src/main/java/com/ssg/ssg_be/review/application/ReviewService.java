package com.ssg.ssg_be.review.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.review.domain.ReviewDtoReq;
import com.ssg.ssg_be.review.domain.ReviewDtoRes;
import com.ssg.ssg_be.review.domain.ReviewPatchDtoReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewService {

    void createReview(ReviewDtoReq reviewDtoReq, Long userId, List<MultipartFile> multipartFile) throws BaseException;

    List<ReviewDtoRes> retrieveReview(Long reviewId) throws BaseException;
    List<ReviewDtoRes> retrieveMyReview(Long userId) throws BaseException;

    void deleteReview(Long reviewId) throws BaseException;
    void updateReview(ReviewPatchDtoReq reviewPatchDtoReq) throws BaseException;


}
