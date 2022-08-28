package com.ssg.ssg_be.wish.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.ssg_be.wish.domain.WishDtoReq;
import com.ssg.ssg_be.wish.domain.WishDtoRes;
import com.ssg.ssg_be.wish.infrastructure.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class WishServiceImpl implements WishServive {

    private WishRepository wishRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public WishServiceImpl(WishRepository wishRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.wishRepository = wishRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createWish(WishDtoReq wishDtoReq, Long userId) throws BaseException {
        try {
            User user = userRepository.getById(userId);
            Product product = productRepository.getById(wishDtoReq.getProductId());

            wishRepository.save(wishDtoReq.toEntity(product, user));

        } catch (Exception exception) {
            throw new BaseException(WISH_INSERT_FAILED);
        }
    }

    @Override
    public List<WishDtoRes> retrieveWish(Long userId) throws BaseException {
        try {
            return wishRepository.findByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(WISH_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteWish(Long wishId) throws BaseException {
        try {
            wishRepository.deleteById(wishId);
        } catch (Exception exception) {
            throw new BaseException(WISH_DELETE_FAILED);
        }
    }
}
