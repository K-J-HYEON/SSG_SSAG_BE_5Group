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
    POST_EXISTS_EMAIL(false,2002,"중복된 이메일입니다."),



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

    // User
    USER_INSERT_FAILED(false, 4001, "사용자 회원가입에 실패하였습니다."),

    // Seller
    SELLER_INSERT_FAILED(false, 4010, "판매자 회원가입에 실패하였습니다."),


    // Wish
    WISH_INSERT_FAILED(false, 4011, "좋아요 누르기에 실패하였습니다."),
    WISH_RETRIEVE_FAILED(false, 4012, "좋아요 조회에 실패하였습니다."),
    WISH_DELETE_FAILED(false, 4013, "좋아요 삭제에 실패하였습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;


    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
