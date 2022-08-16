package com.ssg.ssg_be.wish.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.wish.application.WishServive;
import com.ssg.ssg_be.wish.domain.WishDtoReq;
import com.ssg.ssg_be.wish.domain.WishDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class WishController {

    private final WishServive wishServive;

    @Autowired
    public WishController(WishServive wishServive) {
        this.wishServive = wishServive;
    }

    @PostMapping("/wish")
    public BaseResponse<String> addWish(@RequestBody WishDtoReq wishDtoReq) {
        String result = "";

        try {
            wishServive.createWish(wishDtoReq);
            result = "좋아요 누르기에 성공하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/wish/{userId}")
    public BaseResponse<List<WishDtoRes>> retrieveWish(@PathVariable Long userId) {
        try {
            List<WishDtoRes> wishDtoRes = wishServive.retrieveWish(userId);
            return new BaseResponse<>(wishDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/wish/{wishId}")
    public BaseResponse<String> deleteWish(@PathVariable Long wishId) {
        String result = "";

        try {
            wishServive.deleteWish(wishId);
            result = "좋아요를 삭제하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}