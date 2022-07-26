package com.ssg.ssg_be.qna.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.qna.application.QnaService;
import com.ssg.ssg_be.qna.dto.QnaDtoReq;
import com.ssg.ssg_be.qna.dto.QnaDtoRes;
import com.ssg.ssg_be.qna.dto.QnaPatchDtoReq;
import com.ssg.utils.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class QnaController {

    private final QnaService qnaService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public QnaController(QnaService qnaService, JwtTokenProvider jwtTokenProvider) {
        this.qnaService = qnaService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/qna")
    public BaseResponse<String> addQna(@RequestBody QnaDtoReq qnaDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            qnaService.createQna(qnaDtoReq, userId);
            result = "상품문의 생성에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/qna/{productId}")
    public BaseResponse<List<QnaDtoRes>> retrieveQna(@PathVariable Long productId) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<QnaDtoRes> qnaDtoRes = qnaService.retrieveQna(productId);
            return new BaseResponse<>(qnaDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/qna/user")
    public BaseResponse<List<QnaDtoRes>> retrieveMyQna() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

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

    @PutMapping("/qna")
    public BaseResponse<String> updateQna(@RequestBody QnaPatchDtoReq qnaPatchDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            qnaService.updateQna(qnaPatchDtoReq, userId);
            result = "상품문의를 수정했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
