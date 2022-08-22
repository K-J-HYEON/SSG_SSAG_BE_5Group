package com.ssg.ssg_be.nonmemberorder.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.nonmemberorder.domain.*;

public interface NonMemberOrderService {
    NonMemberOrderIdDtoRes createNonMemberOrders(NonMemberOrderListDtoReq nonMemberOrderListDtoReq) throws BaseException;
    NonMemberOrderListDtoRes retrieveNonMemberOrders(NonMemberGetOrderDtoReq nonMemberGetOrderDtoReq) throws BaseException;
}
