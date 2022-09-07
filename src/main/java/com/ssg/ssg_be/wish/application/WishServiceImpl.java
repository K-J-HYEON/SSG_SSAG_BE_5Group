package com.ssg.ssg_be.wish.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.ssg_be.wish.domain.Wish;
import com.ssg.ssg_be.wish.dto.WishDto;
import com.ssg.ssg_be.wish.dto.WishDtoReq;
import com.ssg.ssg_be.wish.dto.WishDtoRes;
import com.ssg.ssg_be.wish.infrastructure.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class WishServiceImpl implements WishServive {

    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public WishServiceImpl(WishRepository wishRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.wishRepository = wishRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public WishDto createWish(WishDtoReq wishDtoReq, Long userId) throws BaseException {
        if (wishRepository.existsByProductProductIdAndUserUserId(wishDtoReq.getProductId(), userId)) {
            throw new BaseException(POST_EXISTS_WISH);
        }

        try {
            User user = userRepository.getById(userId);
            Product product = productRepository.getById(wishDtoReq.getProductId());

            Wish wish = wishRepository.save(wishDtoReq.toEntity(product, user));
            return new WishDto(wish.getWishId());
        } catch (Exception exception) {
            throw new BaseException(WISH_INSERT_FAILED);
        }
    }

    @Override
    public List<WishDtoRes> retrieveWish(Long userId) throws BaseException {
        try {
            return wishRepository.findByUserUserIdOrderByCreateAtDesc(userId);
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
