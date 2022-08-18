package com.ssg.ssg_be.cart.infrastructure;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.cart.domain.Cart;
import com.ssg.ssg_be.cart.domain.CartDtoRes;
import com.ssg.ssg_be.qna.domain.QnaDtoRes;
import com.ssg.ssg_be.signup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<CartDtoRes> findByUserUserId(Long userId);

    boolean existsByProduct_ProductId(Long productId);
}

//    @ResponseBody
//    @GetMapping("/qna")
//    public BaseResponse<List<QnaDtoRes>> retrieveQna(Long qnaId) {
//        try {
//            List<QnaDtoRes> qnaDtoRes = qnaService.retrieveQna(qnaId);
//            return new BaseResponse<>(qnaDtoRes);
//        } catch (BaseException exception) {
//            return new BaseResponse<>(exception.getStatus());
//        }
//    }
