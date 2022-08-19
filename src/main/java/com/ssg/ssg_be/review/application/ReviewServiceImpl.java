package com.ssg.ssg_be.review.application;
import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.review.domain.ReviewDtoReq;
import com.ssg.ssg_be.review.domain.ReviewDtoRes;
import com.ssg.ssg_be.review.domain.ReviewPatchDtoReq;
import com.ssg.ssg_be.review.infrastructure.ReviewRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.ssg.config.BaseResponseStatus.*;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createReview(ReviewDtoReq reviewDtoReq, Long userId) throws BaseException {
//        User user = userRepository.findByUserId(reviewDtoReq.getUserId()).orElseThrow(() -> new BaseException(NO_EXIST_USER));
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new BaseException(NO_EXIST_USER));
        try {
            Product product = productRepository.getById(reviewDtoReq.getProductId());
            reviewRepository.save(reviewDtoReq.toEntity(product, user));
        } catch (Exception exception) {
            throw new BaseException(REVIEW_INSERT_FAILED);
        }
    }

    @Override
    public List<ReviewDtoRes> retrieveReview(Long reviewId) throws BaseException {
        return null;
    }

    @Override
    public List<ReviewDtoRes> retrieveMyReview(Long userId) throws BaseException {
        return null;
    }

    @Override
    public void deleteReview(Long reviewId) throws BaseException {

    }

    @Override
    public void updateReview(ReviewPatchDtoReq reviewPatchDtoReq) throws BaseException {

    }

//    @Override
//    public List<ReviewDtoRes> retrieveReview(Long productId) throws BaseException {
//        try {
//            return reviewRepository.existsByProduct_ProductId(productId);
//        } catch (Exception exception) {
//            throw new BaseException(REVIEW_RETRIEVE_FAILED);
//        }
//    }
//
//    @Override
//    public List<ReviewDtoRes> retrieveMyReview(Long userId) throws BaseException {
//        return null;
//    }
//
//    @Override
//    public void deleteReview(Long reviewId) throws BaseException {
//
//    }
//
//    @Override
//    public void updateReview(ReviewPatchDtoReq reviewPatchDtoReq) throws BaseException {
//    }
}
