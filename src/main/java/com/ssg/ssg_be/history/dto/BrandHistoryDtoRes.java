package com.ssg.ssg_be.history.dto;

import java.time.LocalDateTime;

public interface BrandHistoryDtoRes {
    Long getBrandHistoryId();
    Long getStoreId();
    String getStoreName();
    LocalDateTime getCreateAt();
}
