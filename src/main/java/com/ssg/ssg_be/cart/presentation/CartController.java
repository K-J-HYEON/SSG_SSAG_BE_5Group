package com.ssg.ssg_be.cart.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.cart.application.CartService;
import com.ssg.ssg_be.cart.domain.*;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CartController {

    private final CartService cartService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public CartController(CartService cartService, JwtTokenProvider jwtTokenProvider) {
        this.cartService = cartService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/carts")
    public BaseResponse<String> addCart(@RequestBody CartDtoReq cartDtoReq) {
        String result = "";
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            if(cartService.createCart(cartDtoReq, userId)) {
                result = "이미 추가된 옵션입니다.";
            } else {
                result = "장바구니 추가에 성공하였습니다.";
            }
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/carts")
    public BaseResponse<List<CartDtoRes>> retrieveCart() {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            List<CartDtoRes> cartDtoRes = cartService.retrieveCart(userId);
            return new BaseResponse<>(cartDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/carts/{cartId}")
    public BaseResponse<String> deleteCart(@PathVariable Long cartId) {
        String result = "";

        try {
            cartService.deleteCart(cartId);
            result = "장바구니 아이템을 삭제했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/carts/count")
    public BaseResponse<String> updateCartCount(@RequestBody CartCountPatchDtoReq cartCountPatchDtoReq) {
        String result = "";

        try {
            cartService.updateCartCount(cartCountPatchDtoReq);
            result = "장바구니 아이템 수량을 수정했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PutMapping("/carts/option")
    public BaseResponse<CartOptionPatchDtoRes> updateCartOption(@RequestBody CartOptionPatchDtoReq cartOptionPatchDtoReq) {
        String token = jwtTokenProvider.getHeader();
        Long userId = Long.valueOf(jwtTokenProvider.getUserPk(token));

        try {
            return new BaseResponse<>(cartService.updateCartOption(cartOptionPatchDtoReq, userId));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
