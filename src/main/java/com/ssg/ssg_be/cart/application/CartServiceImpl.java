package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.CartDtoReq;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.cart.domain.CartPatchDtoReq;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.product.domain.Product;
import com.ssg.ssg_be.product.infrastructure.ProductRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createCart(CartDtoReq cartDtoReq) throws BaseException {
        User user = userRepository.findByUserId(cartDtoReq.getUserId()).orElseThrow(()->new BaseException(NO_EXIST_USER));

        if(cartRepository.existsByProduct_ProductId(cartDtoReq.getProductId())) {
            throw new BaseException(POST_EXISTS_CART);
        }

        try {
            Product product = productRepository.getById(cartDtoReq.getProductId());

            cartRepository.save(cartDtoReq.toEntity(product, user));

        } catch (Exception exception) {
            throw new BaseException(CART_INSERT_FAILED);
        }
    }

    @Override
    public List<CartDtoRes> retrieveCart(Long userId) throws BaseException {
        try {
            return cartRepository.findByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(CART_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteCart(Long cartId) throws BaseException {
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception exception) {
            throw new BaseException(CART_DELETE_FAILED);
        }
    }

    @Override
    public void updateCart(CartPatchDtoReq cartPatchDtoReq) throws BaseException {
        try {
            User user = userRepository.getById(cartPatchDtoReq.getUserId());
            Product product = productRepository.getById(cartPatchDtoReq.getProductId());

            cartRepository.save(cartPatchDtoReq.toEntity(product, user));

        } catch (Exception exception) {
            throw new BaseException(CART_UPDATE_FAILED);
        }
    }
}
