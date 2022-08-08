package com.ssg.ssg_be.login.presentation;

import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.login.application.LoginServiceImpl;
import com.ssg.ssg_be.login.domain.LoginDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LoginController {

    private final LoginServiceImpl loginServiceImpl;

    @Autowired
    public LoginController(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }

    @PostMapping("/login")
    public BaseResponse<String> userLogin(@RequestBody LoginDtoReq loginDtoReq) {
        String result = "";

        return new BaseResponse<>(result);
    }
}
