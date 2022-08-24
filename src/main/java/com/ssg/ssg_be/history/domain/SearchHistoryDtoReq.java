package com.ssg.ssg_be.history.domain;

import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchHistoryDtoReq {

    private Long productId;
    private String searchWord;

    public SearchHistory toEntity(User user) {
        return SearchHistory.builder()
                .searchWord(searchWord)
                .user(user)
                .build();
    }
}
