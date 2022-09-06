package com.ssg.ssg_be.qna.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.qna.dto.QnaDtoReq;
import com.ssg.ssg_be.qna.dto.QnaDtoRes;
import com.ssg.ssg_be.qna.dto.QnaPatchDtoReq;
import com.ssg.ssg_be.qna.infrastructure.QnaRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.ssg.config.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private QnaRepository qnaRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public QnaServiceImpl(QnaRepository qnaRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.qnaRepository = qnaRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createQna(QnaDtoReq qnaDtoReq, Long userId) throws BaseException {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new BaseException(NO_EXIST_USER));
        try {
            Product product = productRepository.getById(qnaDtoReq.getProductId());
            qnaRepository.save(qnaDtoReq.toEntity(product, user));
        } catch (Exception exception) {
            throw new BaseException(QNA_INSERT_FAILED);
        }
    }

    @Override
    public List<QnaDtoRes> retrieveQna(Long productId) throws BaseException {
        try {
            return qnaRepository.findByProductProductId(productId);
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
    public void updateQna(QnaPatchDtoReq qnaPatchDtoReq, Long userId) throws BaseException {
        try {
            User user = userRepository.getById(userId);
            Product product = productRepository.getById(qnaPatchDtoReq.getProductId());
            qnaRepository.save(qnaPatchDtoReq.toEntity(product, user));

        } catch (Exception exception) {
            throw new BaseException(QNA_UPDATE_FAILED);
        }
    }

    @Override
    public List<QnaDtoRes> retrieveMyQna(Long userId) throws BaseException {
        try {
            return qnaRepository.findByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(QNA_RETRIEVE_FAILED);
        }
    }
}
