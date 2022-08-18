package com.ssg.ssg_be.qna.domain;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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
