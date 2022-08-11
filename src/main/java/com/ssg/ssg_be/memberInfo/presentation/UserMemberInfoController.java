package com.ssg.ssg_be.memberInfo.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.memberInfo.application.UserMemberInfoService;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserMemberInfoController {

    private final UserMemberInfoService userRetrieveService;

    @Autowired
    public UserMemberInfoController(UserMemberInfoService userRetrieveService) {
        this.userRetrieveService = userRetrieveService;
    }

    @ResponseBody
    @GetMapping("/info")
    public BaseResponse<UserMemberInfoDtoRes> retrieveUserMember(Long userId) {
        try {
            UserMemberInfoDtoRes userRetrieveDtoRes = userRetrieveService.retrieveUserMember(userId);
            return new BaseResponse(userRetrieveDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
