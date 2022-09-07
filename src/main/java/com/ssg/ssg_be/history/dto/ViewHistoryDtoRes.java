package com.ssg.ssg_be.history.dto;

import java.time.LocalDateTime;

public interface ViewHistoryDtoRes {
    Long getViewHistoryId();

    String getName();

    int getPrice();

    String getProductImg();

    Long getProductId();

    Long getUserUserId();

    LocalDateTime getCreateAt();
}
