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
    POST_EXISTS_CART(false,2003,"이미 장바구니에 있는 상품입니다."),

    /**
     * 3000: Response 오류
     * **/
    // Common
    FAILED_TO_LOGIN(false,3000,"없는 아이디거나 비밀번호가 틀렸습니다."),
    NO_LOOKUP_VALUE(false, 3001, "조회된 데이터가 없습니다."),
    JWT_CREATE_FAILED(false, 3002, "토큰 생성에 실패하였습니다."),
    NO_EXIST_USER(false, 3003, "존재하지 않는 유저 정보입니다."),

    /**
     * 4000: Database 오류
     * **/
    // Common
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SEARCH_RETRIEVE_FAILED(false, 4001, "상품 검색에 실패했습니다."),
    PRODUCT_RETRIEVE_FAILED(false, 4002, "상품 조회에 실패했습니다."),
    CATEGORY_RETRIEVE_FAILED(false, 4003, "카테고리 조회에 실패했습니다."),

    // User
    USER_INSERT_FAILED(false, 4010, "사용자 회원가입에 실패하였습니다."),
    USER_RETRIEVE_FAILED(false, 4011, "회원정보 조회에 실패했습니다."),
    USER_UPDATE_FAILED(false, 4012, "회원정보 변경에 실패했습니다."),
    CART_INSERT_FAILED(false, 4020, "장바구니 담기에 실패하였습니다."),
    CART_RETRIEVE_FAILED(false, 4021, "장바구니 조회에 실패하였습니다."),
    CART_DELETE_FAILED(false, 4022, "장바구니 삭제에 실패하였습니다."),
    CART_UPDATE_FAILED(false, 4023, "장바구니 수정에 실패하였습니다."),
    WISH_INSERT_FAILED(false, 4030, "좋아요 누르기에 실패하였습니다."),
    WISH_RETRIEVE_FAILED(false, 4031, "좋아요 조회에 실패하였습니다."),
    WISH_DELETE_FAILED(false, 4032, "좋아요 삭제에 실패하였습니다."),
    SHIPPING_ADDR_INSERT_FAILED(false, 4040, "배송지 추가에 실패하였습니다."),
    SHIPPING_ADDR_RETRIEVE_FAILED(false, 4041, "배송지 조회에 실패하였습니다."),
    SHIPPING_ADDR_UPDATE_FAILED(false, 4042, "배송지 수정에 실패하였습니다."),
    SHIPPING_ADDR_DELETE_FAILED(false, 4043, "배송지 삭제에 실패하였습니다."),
    PAYMENT_METHOD_INSERT_FAILED(false, 4050, "결제수단 추가에 실패하였습니다."),
    PAYMENT_METHOD_RETRIEVE_FAILED(false, 4051, "결제수단 조회에 실패하였습니다."),
    PAYMENT_METHOD_DELETE_FAILED(false, 4052, "결제수단 삭제에 실패하였습니다."),

    /**
     * 5000: S3 오류
     * **/
    // Common
    TRANSLATE_FILE_FAILED(false, 5000, "파일 변환에 실패하였습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;


    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
