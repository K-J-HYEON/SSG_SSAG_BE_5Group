package com.ssg.ssg_be.qna.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.qna.application.QnaService;
import com.ssg.ssg_be.qna.domain.QnaDtoReq;
import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import com.ssg.ssg_be.qna.domain.QnaPatchDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class QnaController {

    private final QnaService qnaService;

    @Autowired
    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    @PostMapping("/qna")
    public BaseResponse<String> addQna(@RequestBody QnaDtoReq qnaDtoReq) {
        String result = "";

        try {
            qnaService.createQna(qnaDtoReq);
            result = "상품문의 생성에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/qna/{productId}")
    public BaseResponse<List<QnaDtoRes>> retrieveQna(@PathVariable Long productId) {
        try {
            List<QnaDtoRes> qnaDtoRes = qnaService.retrieveQna(productId);
            return new BaseResponse<>(qnaDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/qna/user/{userId}")
    public BaseResponse<List<QnaDtoRes>> retrieveMyQna(@PathVariable Long userId) {
        try {
            List<QnaDtoRes> qnaDtoRes = qnaService.retrieveMyQna(userId);
            return new BaseResponse<>(qnaDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/qna/{qnaId}")
    public BaseResponse<String> deleteQna(@PathVariable Long qnaId) {
        String result = "";

        try {
            qnaService.deleteQna(qnaId);
            result = "상품문의를 삭제했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/qna/{qnaId}")
    public BaseResponse<String> updateQna(@RequestBody QnaPatchDtoReq qnaPatchDtoReq) {
        String result = "";

        try {
            qnaService.updateQna(qnaPatchDtoReq);
            result = "상품문의를 수정했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
