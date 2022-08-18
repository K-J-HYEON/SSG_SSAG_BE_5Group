package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.*;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ProductOptionRepository productOptionRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public boolean createCart(CartDtoReq cartDtoReq) throws BaseException {
        User user = userRepository.findByUserId(cartDtoReq.getUserId()).orElseThrow(()->new BaseException(NO_EXIST_USER));
        boolean isOverlap = false;

        try {
            ProductOption productOption = productOptionRepository.getById(cartDtoReq.getProductOptionId());

            // 장바구니에 해당 옵션이 이미 존재하는 경우, 수량만 더해 줌. 존재하지 않는 경우는 해당 옵션을 장바구니에 새로 추가
            if(cartRepository.existsByUserUserIdAndProductOption_ProductOptionId(cartDtoReq.getUserId(), cartDtoReq.getProductOptionId())) {
                Cart cart = cartRepository.findByUserUserIdAndProductOption_ProductOptionId(cartDtoReq.getUserId(), cartDtoReq.getProductOptionId());

                cartDtoReq.setCount(cartDtoReq.getCount()+cart.getCount());
                cartRepository.save(cartDtoReq.toOriginEntity(user, productOption, cart.getCartId()));
                isOverlap = true;
            } else {
                cartRepository.save(cartDtoReq.toEntity(user, productOption));
            }
        } catch (Exception exception) {
            throw new BaseException(CART_INSERT_FAILED);
        }

        return isOverlap;
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
    public void updateCartCount(CartCountPatchDtoReq cartCountPatchDtoReq) throws BaseException {
        try {
            Cart cart = cartRepository.getById(cartCountPatchDtoReq.getCartId());

            cartRepository.save(cartCountPatchDtoReq.toEntity(cart.getUser(), cart.getProductOption()));

        } catch (Exception exception) {
            throw new BaseException(CART_COUNT_UPDATE_FAILED);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public CartOptionPatchDtoRes updateCartOption(CartOptionPatchDtoReq cartOptionPatchDtoReq) throws BaseException {
        Cart cart = cartRepository.getById(cartOptionPatchDtoReq.getCartId());

        ProductOption productOption = productOptionRepository.getById(cartOptionPatchDtoReq.getProductOptionId());
        Long productId = productOption.getProduct().getProductId();

        ProductOption newProductOption;
        try {
            newProductOption = productOptionRepository.findByProductProductIdAndColorColorIdAndSizeSizeId(productId, cartOptionPatchDtoReq.getColorId(), cartOptionPatchDtoReq.getSizeId());
        } catch(Exception exception) {
            throw new BaseException(OPTION_RETRIEVE_FAILED);
        }

        try {
            if(cartRepository.existsByUserUserIdAndProductOption_ProductOptionId(cartOptionPatchDtoReq.getUserId(), newProductOption.getProductOptionId())) {
                Cart overlapCart = cartRepository.findByUserUserIdAndProductOption_ProductOptionId(cartOptionPatchDtoReq.getUserId(), newProductOption.getProductOptionId());

                cartRepository.save(Cart.builder()
                            .cartId(overlapCart.getCartId())
                            .productOption(newProductOption)
                            .user(overlapCart.getUser())
                            .count(overlapCart.getCount()+cart.getCount())
                            .build());

                cartRepository.deleteById(cart.getCartId());
                return new CartOptionPatchDtoRes(overlapCart.getCartId(), newProductOption, overlapCart.getCount()+cart.getCount());

            } else {
                cartRepository.save(Cart.builder()
                            .cartId(cartOptionPatchDtoReq.getCartId())
                            .productOption(newProductOption)
                            .user(cart.getUser())
                            .count(cart.getCount())
                            .build());
                return new CartOptionPatchDtoRes(cartOptionPatchDtoReq.getCartId(), newProductOption, cart.getCount());
            }
        } catch(Exception exception) {
            throw new BaseException(CART_OPTION_UPDATE_FAILED);
        }
    }
}
