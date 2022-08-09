package com.ssg.ssg_be.shippingaddr.domain;

import com.ssg.ssg_be.signup.domain.User;

public interface ShippingAddrDtoRes {
    User getUser();
    String getAddrName();    // 주소 별칭
    String getRecipient();   // 받는 분
    String getPhone();
    String getHomePhone();
    String getZipCode();      // 우편번호
    String getStreetAddr();   // 도로명 주소
    String getLotAddr();      // 지번 주소
}
