package com.ssg.ssg_be.history.domain;

import java.time.LocalDateTime;

public interface ViewHistoryDtoRes {
    Long getViewHistoryId();
    String getName();
    int getPrice();
    String getProductImg();

    Long getUserUserId();
    LocalDateTime getCreateAt();
}