package com.ssg.ssg_be.login.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.login.application.LoginService;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/social/{token}")
    public BaseResponse<String> socialLogin(@PathVariable String token) {

        return new BaseResponse<>(token);
    }
}
