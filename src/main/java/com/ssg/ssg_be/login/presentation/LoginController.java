package com.ssg.ssg_be.login.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.login.application.LoginService;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import com.ssg.ssg_be.login.domain.PostLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/comm-users")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login/user")
    public BaseResponse<String> userLogin(@RequestBody LoginDtoReq loginDtoReq) {
        String token = "";

        try {
            token = loginService.userLogin(loginDtoReq);
            return new BaseResponse<>(token);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // 카카오 로그인 API
    /**
     * [GET] /app/login/kakao
     * @return BaseResponse<String>
     */
//    @ResponseBody
//    @GetMapping("/kakao")
//    public BaseResponse<PostLoginRes> kakaoLogin(@RequestParam(required = false) String code) {
//        try {
//            // URL에 포함된 code를 이용하여 엑세스 토큰 발급
//            String accessToken = loginService.getKakaoAccessToken(code);
//            System.out.println(accessToken);
//
//            // 엑세스 토큰 이용해서 kakao server에서 닉네임 이메일 받아오기
//            HashMap<String, Object> userInfo = loginService.getUserInfo(accessToken);
//            System.out.println("login Controller : " + userInfo);
//
//            PostLoginRes postLoginRes = null;
//
//            if(loginProvider.checkEmail(String.valueOf(userInfo.get("email")) == 0)) {
//                // PostLoginRes postLoginRes = 해당 서비스;
//                return new BaseResponse<>(postLoginRes);
//            } else {
//                postLoginRes = loginProvider.getUserInfo(String.valueOf(userInfo.get("email")));
//                return new BaseResponse<>(postLoginRes);
//            }
//        } catch (BaseException exception) {
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

    /**
     * 카카오 토큰 갱신 API
     * [GET] /app/login/kakao/:userId
     * @return BaseResponse<String>
     */
//    @ResponseBody
//    @GetMapping("/kakao/{userId}")
//    public BaseResponse<String> updateKakaoToken(@PathVariable int userId) {
//        String result = "";
//
//        try {
//            //jwt에서 id 추출.
//            int userIdxByJwt = jwtService.getUserIdx();
//            //userIdx와 접근한 유저가 같은지 확인
//            if(userId != userIdxByJwt){
//                return new BaseResponse<>(INVALID_USER_JWT);
//            }
//
//            loginService.updateKakaoToken(userId);
//
//            return new BaseResponse<>(result);
//        } catch (BaseException exception) {
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

}
