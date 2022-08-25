package com.ssg.ssg_be.history.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.history.domain.ViewHistory;
import com.ssg.ssg_be.history.domain.ViewHistoryDtoRes;
import com.ssg.ssg_be.history.infrastructure.BrandHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.CategoryHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.SearchHistoryRepository;
import com.ssg.ssg_be.history.infrastructure.ViewHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Slf4j
@Service
public class HistoryServiceImpl implements HistoryService {
    private final BrandHistoryRepository brandHistoryRepository;
    private final CategoryHistoryRepository categoryHistoryRepository;
    private final ViewHistoryRepository viewHistoryRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    public HistoryServiceImpl(BrandHistoryRepository brandHistoryRepository, CategoryHistoryRepository categoryHistoryRepository, ViewHistoryRepository viewHistoryRepository, SearchHistoryRepository searchHistoryRepository) {
        this.brandHistoryRepository = brandHistoryRepository;
        this.categoryHistoryRepository = categoryHistoryRepository;
        this.viewHistoryRepository = viewHistoryRepository;
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public List<ViewHistoryDtoRes> retrieveViewHistory(Long userId) throws BaseException {
        try {
            return viewHistoryRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(VIEWHISTORY_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteViewHistory(Long viewHistoryId) throws BaseException {
        try {
            viewHistoryRepository.deleteById(viewHistoryId);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DELETE_FAILED);
        }
    }

//    @Override
}
