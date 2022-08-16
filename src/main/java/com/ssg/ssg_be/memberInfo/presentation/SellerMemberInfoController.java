package com.ssg.ssg_be.memberInfo.presentation;

import com.ssg.config.BaseException;
import com.ssg.config.BaseResponse;
import com.ssg.ssg_be.memberInfo.application.SellerMemberInfoService;
import com.ssg.ssg_be.memberInfo.domain.SellerMemberInfoDtoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerMemberInfoController {

    private final SellerMemberInfoService sellerRetrieveService;

    @Autowired
    public SellerMemberInfoController(SellerMemberInfoService sellerRetrieveService) {
        this.sellerRetrieveService = sellerRetrieveService;
    }

    @ResponseBody
    @GetMapping("/info/{sellerId}")
    public BaseResponse<List<SellerMemberInfoDtoRes>> retrieveSellerMember(@PathVariable Long sellerId) {
        try {
            SellerMemberInfoDtoRes sellerRetrieveDtoRes = sellerRetrieveService.retrieveSellerMember(sellerId);
            return new BaseResponse(sellerRetrieveDtoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

//    @ResponseBody
//    @PutMapping("/info")
//    public BaseResponse<String>
}
