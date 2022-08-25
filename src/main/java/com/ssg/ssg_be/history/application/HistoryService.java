package com.ssg.ssg_be.history.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.history.domain.ViewHistoryDtoRes;

import java.util.List;

public interface HistoryService {
    List<ViewHistoryDtoRes> retrieveViewHistory(Long userId) throws BaseException;

    void deleteViewHistory(Long viewHistoryId) throws BaseException;

//    List<>
}
