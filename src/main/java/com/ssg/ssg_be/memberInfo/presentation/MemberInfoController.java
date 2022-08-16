package com.ssg.ssg_be.memberInfo.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.memberInfo.application.MemberInfoService;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoPutDtoReq;
import com.ssg.ssg_be.memberInfo.domain.MemberUpdatePasswordDtoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MemberInfoController {

    private final MemberInfoService userRetrieveService;
    private final MemberInfoService userUpdateService;

    @Autowired
    public MemberInfoController(MemberInfoService userRetrieveService, MemberInfoService userUpdateService) {
        this.userRetrieveService = userRetrieveService;
        this.userUpdateService = userUpdateService;
    }

    @ResponseBody
    @GetMapping("/info/{userId}")
    public BaseResponse<MemberInfoDtoRes> retrieveUserMember(@PathVariable Long userId) {
        try {
            MemberInfoDtoRes userRetrieveDtoRes = userRetrieveService.retrieveUserMember(userId);
            return new BaseResponse<>(userRetrieveDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/info")
    public BaseResponse<String> updateMemberInfo(@RequestBody MemberInfoPutDtoReq memberInfoPutDtoReq) {
        String result = "";
        try {
            userUpdateService.updateUserMember(memberInfoPutDtoReq);
            result = "회원정보를 변경하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PutMapping("/info/password")
    public BaseResponse<String> updatePassword(@RequestBody MemberUpdatePasswordDtoReq memberUpdatePasswordPutDtoReq) throws BaseException {
        String result = "";
        try {
            userUpdateService.updateUserPassword(memberUpdatePasswordPutDtoReq);
            result = "비밀번호를 변경하였습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
