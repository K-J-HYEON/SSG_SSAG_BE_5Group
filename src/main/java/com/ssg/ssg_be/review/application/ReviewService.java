package com.ssg.ssg_be.review.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.review.domain.ReviewDtoReq;

public interface ReviewService {

    void createReview(ReviewDtoReq reviewDtoReq, Long userId) throws BaseException;
}
