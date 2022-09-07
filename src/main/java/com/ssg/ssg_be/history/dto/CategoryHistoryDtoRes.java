package com.ssg.ssg_be.history.dto;

import java.time.LocalDateTime;

public interface CategoryHistoryDtoRes {
    Long getCategoryHistoryId();

    Long getCategoryId();

    String getCategoryName();

    int getCategoryType();

    LocalDateTime getCreateAt();


}
