package com.ssg.ssg_be.memberInfo.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.memberInfo.application.UserMemberInfoService;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoPutDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserMemberInfoController {

    private final UserMemberInfoService userRetrieveService;
    private final UserMemberInfoService userUpdateService;

    @Autowired
    public UserMemberInfoController(UserMemberInfoService userRetrieveService, UserMemberInfoService userUpdateService) {
        this.userRetrieveService = userRetrieveService;
        this.userUpdateService = userUpdateService;
    }

    @ResponseBody
    @GetMapping("/info/{userId}")
    public BaseResponse<UserMemberInfoDtoRes> retrieveUserMember(@PathVariable Long userId) {
        try {
            UserMemberInfoDtoRes userRetrieveDtoRes = userRetrieveService.retrieveUserMember(userId);
            return new BaseResponse<>(userRetrieveDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/info")
    public BaseResponse<String> updateMemberInfo(@RequestBody UserMemberInfoPutDtoReq userMemberInfoPutDtoReq) {
        String result = "";

        try {
            userUpdateService.updateUserMember(userMemberInfoPutDtoReq);
            result = "회원정보를 변경하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
