package com.ssg.ssg_be.history.infrastructure;

import com.ssg.ssg_be.history.domain.SearchHistory;
import com.ssg.ssg_be.history.dto.SearchHistoryDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistoryDtoRes> findAllByUserUserId(Long userId);
    boolean existsByUserUserIdAndSearchWord(Long userId, String searchWord);
    SearchHistory findByUserUserIdAndSearchWord(Long userId, String searchWord);
}
