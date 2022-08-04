package com.ssg.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    /**
     * 1000: 요청 성공
     * **/
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     * 2000: Request 오류
     * **/
    // Common
    POST_EXISTS_LOGIN_ID(false,2000,"중복된 아이디입니다."),
    POST_EXISTS_PHONE(false,2001,"중복된 휴대폰 번호입니다."),



    // Seller
    POST_SELLERS_EXISTS_CORPORATION_NUM(false,2020,"중복된 법인번호입니다."),


    /**
     * 3000: Response 오류
     * **/



    /**
     * 4000: Database 오류
     * **/
    // Common
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),


    // Seller
    SELLER_INSERT_FAILED(false, 4010, "판매자 회원가입에 실패하였습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;

    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
