package com.ssg.ssg_be.review.domain;

import java.time.LocalDateTime;

public interface ReviewDtoRes {
    Long getReviewId();

    String getContent();
    int getScore();

    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();

    Long getUserUserId();
    String getUserLoginId();
}
