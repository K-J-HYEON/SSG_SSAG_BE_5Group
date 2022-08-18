package com.ssg.ssg_be.qna.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.qna.domain.QnaDtoReq;
import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import com.ssg.ssg_be.qna.domain.QnaPatchDtoReq;
import com.ssg.ssg_be.qna.infrastructure.QnaRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.ssg.config.BaseResponseStatus.*;

@Service
public class QnaServiceImpl implements QnaService {

    private final QnaRepository qnaRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public QnaServiceImpl(QnaRepository qnaRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.qnaRepository = qnaRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createQna(QnaDtoReq qnaDtoReq) throws BaseException {
        User user = userRepository.findByUserId(qnaDtoReq.getUserId()).orElseThrow(() -> new BaseException(NO_EXIST_USER));
        try {
            Product product = productRepository.getById(qnaDtoReq.getProductId());
            qnaRepository.save(qnaDtoReq.toEntity(product, user));
        } catch (Exception exception) {
            throw new BaseException(QNA_INSERT_FAILED);
        }
    }

    @Override
    public List<QnaDtoRes> retrieveQna(Long userId) throws BaseException {
        try {
            return qnaRepository.findByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(QNA_RETRIEVE_FAILED);
        }
    }



    @Override
    public void deleteQna(Long qnaId) throws BaseException {
        try {
            qnaRepository.deleteById(qnaId);
        } catch (Exception exception) {
            throw new BaseException(QNA_DELETE_FAILED);
        }
    }

    @Override
    public void updateQna(QnaPatchDtoReq qnaPatchDtoReq) throws BaseException {
        try {
            User user = userRepository.getById(qnaPatchDtoReq.getUserId());
            Product product = productRepository.getById(qnaPatchDtoReq.getProductId());
            qnaRepository.save(qnaPatchDtoReq.toEntity(product, user));

        } catch (Exception exception) {
            throw new BaseException(QNA_UPDATE_FAILED);
        }
    }
}
