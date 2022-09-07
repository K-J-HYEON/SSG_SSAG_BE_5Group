package com.ssg.ssg_be.history.dto;

import java.time.LocalDateTime;

public interface SearchHistoryDtoRes {
    Long getSearchHistoryId();

    String getSearchWord();

    LocalDateTime getCreateAt();

}
