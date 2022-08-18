package com.ssg.ssg_be.qna.infrastructure;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.qna.domain.Qna;
import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {
    List<QnaDtoRes> findByUserUserId(Long userId);
    boolean existByQna_QnaId(Long qnaId);

    List<Qna> findByMyId(Long userId);

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
