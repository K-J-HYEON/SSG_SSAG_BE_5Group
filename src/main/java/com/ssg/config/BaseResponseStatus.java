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
     **/
    NO_LOOKUP_VALUE(false, 3002, "조회된 데이터가 없습니다."),

    /**
     * 4000: Database 오류
     * **/
    // Common
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SEARCH_RETRIEVE_FAILED(false, 4017, "상품 검색에 실패했습니다."),
    PRODUCT_RETRIEVE_FAILED(false, 4018, "상품 조회에 실패했습니다."),
    CATEGORY_RETRIEVE_FAILED(false, 4019, "카테고리 조회에 실패했습니다."),

    // User
    USER_INSERT_FAILED(false, 4001, "사용자 회원가입에 실패하였습니다."),
    CART_INSERT_FAILED(false, 4002, "장바구니 담기에 실패하였습니다."),
    CART_RETRIEVE_FAILED(false, 4003, "장바구니 조회에 실패하였습니다."),
    CART_DELETE_FAILED(false, 4004, "장바구니 삭제에 실패하였습니다."),
    CART_UPDATE_FAILED(false, 4005, "장바구니 수정에 실패하였습니다."),
    WISH_INSERT_FAILED(false, 4011, "좋아요 누르기에 실패하였습니다."),
    WISH_RETRIEVE_FAILED(false, 4012, "좋아요 조회에 실패하였습니다."),
    WISH_DELETE_FAILED(false, 4013, "좋아요 삭제에 실패하였습니다."),
    SHIPPING_ADDR_INSERT_FAILED(false, 4030, "배송지 추가에 실패하였습니다."),
    SHIPPING_ADDR_RETRIEVE_FAILED(false, 4031, "배송지 조회에 실패하였습니다."),
    SHIPPING_ADDR_UPDATE_FAILED(false, 4032, "배송지 수정에 실패하였습니다."),
    SHIPPING_ADDR_DELETE_FAILED(false, 4033, "배송지 삭제에 실패하였습니다."),
    PAYMENT_METHOD_INSERT_FAILED(false, 4040, "결제수단 추가에 실패하였습니다."),
    PAYMENT_METHOD_RETRIEVE_FAILED(false, 4041, "결제수단 조회에 실패하였습니다."),
    PAYMENT_METHOD_DELETE_FAILED(false, 4042, "결제수단 삭제에 실패하였습니다."),
    USER_RETRIEVE_FAILED(false, 4043, "회원정보 조회에 실패했습니다."),

    // Seller
    SELLER_INSERT_FAILED(false, 4010, "판매자 회원가입에 실패하였습니다."),
    SELLER_RETRIEVE_FAILED(false, 4011, "판매자 회원정보 조회에 실패하였습니다."),

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
