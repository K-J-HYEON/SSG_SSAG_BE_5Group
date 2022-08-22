package com.ssg.ssg_be.qna.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.qna.domain.QnaDtoReq;
import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import com.ssg.ssg_be.qna.domain.QnaPatchDtoReq;

import java.util.List;

public interface QnaService {
    void createQna(QnaDtoReq qnaDtoReq, Long userId) throws BaseException;

    List<QnaDtoRes> retrieveQna(Long qnaId) throws BaseException;
    List<QnaDtoRes> retrieveMyQna(Long userId) throws BaseException;

    void deleteQna(Long qnaId) throws BaseException;
    void updateQna(QnaPatchDtoReq qnaPatchDtoReq, Long userId) throws BaseException;


}
