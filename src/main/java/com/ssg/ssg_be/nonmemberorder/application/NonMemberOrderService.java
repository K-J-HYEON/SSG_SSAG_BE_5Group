package com.ssg.ssg_be.nonmemberorder.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberAuthDtoReq;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderIdDtoRes;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderListDtoReq;
import com.ssg.ssg_be.nonmemberorder.dto.NonMemberOrderListDtoRes;

public interface NonMemberOrderService {
    NonMemberOrderIdDtoRes createNonMemberOrders(NonMemberOrderListDtoReq nonMemberOrderListDtoReq) throws BaseException;

    NonMemberOrderListDtoRes retrieveNonMemberOrders(Long orderId) throws BaseException;

    boolean authNonMember(NonMemberAuthDtoReq nonMemberAuthDtoReq);

    void cancelNonMemberOrder(Long orderId) throws BaseException;

    void updateNonMemberOrder(Long orderId, int type) throws BaseException;
}
