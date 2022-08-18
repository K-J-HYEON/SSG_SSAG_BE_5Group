package com.ssg.ssg_be.qna.domain;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.signup.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface QnaDtoRes {
    Long getQnaId();
    User getUser();
    Product getProduct();

    int getType();
    String getTitle();
    String getContent();
    int getAnswerStatus();

//    @ResponseBody
//    @GetMapping("/qna")
//    public BaseResponse<List<QnaDtoRes>> retrieveQna(Long qnaId) {
//        try {
//            List<QnaDtoRes> qnaDtoRes = qnaService.retrieveQna(qnaId);
//            return new BaseResponse<>(qnaDtoRes);
//        } catch (BaseException exception) {
//            return new BaseResponse<>(exception.getStatus());
//        }
//    }
}
