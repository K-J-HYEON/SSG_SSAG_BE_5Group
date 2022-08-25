package com.ssg.ssg_be.history.domain;

import java.time.LocalDateTime;

public interface SearchHistoryDtoRes {
    Long getSearchHistoryId();
    String getSearchWord();
    LocalDateTime getCreateAt();

}
