package com.ssg.ssg_be.cart.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.cart.application.CartService;
import com.ssg.ssg_be.cart.domain.CartDtoReq;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.cart.domain.CartPatchDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/lists")
    public BaseResponse<String> addCart(@RequestBody CartDtoReq cartDtoReq) {
        String result = "";

        try {
            cartService.createCart(cartDtoReq);
            result = "장바구니 추가에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/lists/{userId}")
    public BaseResponse<List<CartDtoRes>> retrieveCart(@PathVariable Long userId) {
        try {
            List<CartDtoRes> cartDtoRes = cartService.retrieveCart(userId);
            return new BaseResponse<>(cartDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/lists/{cartId}")
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

    @PutMapping("/lists")
    public BaseResponse<String> updateCart(@RequestBody CartPatchDtoReq cartPatchDtoReq) {
        String result = "";

        try {
            cartService.updateCart(cartPatchDtoReq);
            result = "장바구니 아이템을 수정했습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
