package com.ssg.ssg_be.qna.domain;

import java.time.LocalDateTime;

public interface QnaDtoRes {
    Long getQnaId();

    int getType();
    String getTitle();
    String getContent();
    int getSecret();
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();
    int getAnswerStatus();

    Long getUserUserId();
    String getUserLoginId();

}
