package com.ssg.ssg_be.review.dto;

import java.time.LocalDateTime;

public interface ReviewDtoRes {
    Long getReviewId();

    int getScore();

    String getContent();

    LocalDateTime getCreateAt();

    LocalDateTime getUpdateAt();

    Long getUserUserId();

    String getUserLoginId();
}
