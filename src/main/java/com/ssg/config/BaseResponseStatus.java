package com.ssg.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    /**
     * 1000: 요청 성공
     **/
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     * 2000: Request 오류
     **/
    // Common
    POST_EXISTS_LOGIN_ID(false, 2000, "중복된 아이디입니다."),
    POST_EXISTS_PHONE(false, 2001, "중복된 휴대폰 번호입니다."),
    POST_EXISTS_EMAIL(false, 2002, "중복된 이메일입니다."),
    POST_EXISTS_CART(false, 2003, "이미 장바구니에 있는 상품입니다."),
    POST_EXISTS_QNA(false, 2004, "중복된 문의&답변 입니다."),
    AUTH_NUM_IS_NULL(false, 2005, "인증번호가 비어 있습니다."),
    INVALID_PHONE_NUM(false, 2006, "유효하지 않은 전화번호 형식입니다."),
    POST_EXISTS_WISH(false, 2007, "중복된 좋아요 요청입니다."),

    /**
     * 3000: Response 오류
     **/
    // Common
    FAILED_TO_LOGIN(false, 3000, "없는 아이디거나 비밀번호가 틀렸습니다."),
    NO_LOOKUP_VALUE(false, 3001, "조회된 데이터가 없습니다."),
    JWT_CREATE_FAILED(false, 3002, "토큰 생성에 실패하였습니다."),
    NO_EXIST_USER(false, 3003, "존재하지 않는 유저 정보입니다."),
    OUT_OF_STOCK(false, 3004, "상품 재고량이 부족합니다."),
    ALREADY_BEING_PREPARED(false, 3005, "이미 준비 중인 상품입니다."),

    /**
     * 4000: Database 오류
     **/
    // Common
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SEARCH_RETRIEVE_FAILED(false, 4001, "상품 검색에 실패했습니다."),
    PRODUCT_RETRIEVE_FAILED(false, 4002, "상품 조회에 실패했습니다."),
    CATEGORY_RETRIEVE_FAILED(false, 4003, "카테고리 조회에 실패했습니다."),

    // User
    USER_INSERT_FAILED(false, 4010, "사용자 회원가입에 실패하였습니다."),
    USER_RETRIEVE_FAILED(false, 4011, "회원정보 조회에 실패했습니다."),
    USER_UPDATE_FAILED(false, 4012, "회원정보 변경에 실패했습니다."),
    PASSWORD_RETRIEVE_FAILED(false, 4013, "비밀번호 조회에 실패했습니다."),
    PASSWORD_UPDATE_FAILED(false, 4014, "비밀번호 변경에 실패했습니다."),
    CART_INSERT_FAILED(false, 4020, "장바구니 담기에 실패하였습니다."),
    CART_RETRIEVE_FAILED(false, 4021, "장바구니 조회에 실패하였습니다."),
    CART_DELETE_FAILED(false, 4022, "장바구니 삭제에 실패하였습니다."),
    CART_COUNT_UPDATE_FAILED(false, 4023, "장바구니 수량 수정에 실패하였습니다."),
    CART_OPTION_UPDATE_FAILED(false, 4024, "장바구니 옵션 수정에 실패하였습니다."),
    OPTION_RETRIEVE_FAILED(false, 4025, "옵션 조회에 실패하였습니다."),
    OPTION_COLOR_RETRIEVE_FAILED(false, 4026, "색상 옵션 조회에 실패하였습니다."),
    OPTION_SIZE_RETRIEVE_FAILED(false, 4027, "사이즈 옵션 조회에 실패하였습니다."),
    WISH_INSERT_FAILED(false, 4030, "좋아요 누르기에 실패하였습니다."),
    WISH_RETRIEVE_FAILED(false, 4031, "좋아요 조회에 실패하였습니다."),
    WISH_DELETE_FAILED(false, 4032, "좋아요 삭제에 실패하였습니다."),
    SHIPPING_ADDR_INSERT_FAILED(false, 4040, "배송지 추가에 실패하였습니다."),
    SHIPPING_ADDR_RETRIEVE_FAILED(false, 4041, "배송지 조회에 실패하였습니다."),
    SHIPPING_ADDR_UPDATE_FAILED(false, 4042, "배송지 수정에 실패하였습니다."),
    SHIPPING_ADDR_DELETE_FAILED(false, 4043, "배송지 삭제에 실패하였습니다."),
    SHIPPING_ADDR_DEFAULT_UPDATE_FAILED(false, 4044, "기본 배송지 변경에 실패하였습니다."),
    PAYMENT_METHOD_INSERT_FAILED(false, 4050, "결제수단 추가에 실패하였습니다."),
    PAYMENT_METHOD_RETRIEVE_FAILED(false, 4051, "결제수단 조회에 실패하였습니다."),
    PAYMENT_METHOD_DELETE_FAILED(false, 4052, "결제수단 삭제에 실패하였습니다."),
    QNA_INSERT_FAILED(false, 4053, "문의답변에 실패했습니다."),
    QNA_RETRIEVE_FAILED(false, 4054, "문의답변에 조회에 실패했습니다."),
    QNA_DELETE_FAILED(false, 4055, "문의답변에 삭제에 실패했습니다."),
    QNA_UPDATE_FAILED(false, 4056, "문의답변에 수정에 실패했습니다."),
    REVIEW_INSERT_FAILED(false, 4057, "리뷰작성에 실패했습니다."),
    REVIEW_RETRIEVE_FAILED(false, 4058, "리뷰조회에 실패했습니다."),
    REVIEW_DELETE_FAILED(false, 4059, "리뷰삭제에 실패했습니다."),
    REVIEW_UPDATE_FAILED(false, 4059, "리뷰수정에 실패했습니다."),
    PRODUCT_IMG_RETRIEVE_FAILED(false, 4060, "상품 이미지 조회에 실패했습니다."),
    REVIEW_TOTAL_RETRIEVE_FAILED(false, 4061, "리뷰 통계 조회에 실패했습니다."),
    ORDER_INSERT_FAILED(false, 4062, "주문 추가에 실패하였습니다."),
    REDUCE_STOCK_FAILED(false, 4063, "재고 감소에 실패하였습니다."),
    ORDER_RETRIEVE_FAILED(false, 4064, "주문 목록 조회에 실패하였습니다."),
    ORDER_CANCEL_FAILED(false, 4065, "주문 취소에 실패하였습니다."),
    ORDER_CHANGE_FAILED(false, 4066, "반품&교환 신청에 실패하였습니다."),
    OVERDUE_ORDER_CHANGE(false, 4067, "반품&교환 신청 가능한 기간이 지났습니다."),
    UNABLE_TO_CHANGE_ORDER(false, 4068, "반품&교환 신청이 불가능한 주문 상태입니다."),
    ORDER_DELETE_FAILED(false, 4069, "주문 목록 삭제에 실패하였습니다."),
    UNABLE_TO_CANCEL_ORDER(false, 4070, "취소가 불가능한 주문 상태입니다."),
    BANNER_RETRIEVE_FAILED(false, 4071, "배너 조회에 실패했습니다."),
    HAPPY_LOUNGE_RETRIEVE_FAILED(false, 4072, "해피 라운지 조회에 실패했습니다."),
    NEW_SERVICE_RETRIEVE_FAILED(false, 4073, "새로운 서비스 조회에 실패했습니다."),
    CARD_PROMOTION_RETRIEVE_FAILED(false, 4074, "카드 프로모션 조회에 실패했습니다."),
    HOT_BRAND_RETRIEVE_FAILED(false, 4075, "핫 브랜드 조회에 실패했습니다."),
    VIEWHISTORY_RETRIEVE_FAILED(false, 4076, "최근 상품 조회에 실패했습니다."),
    VIEWHISTORY_DELETE_FAILED(false, 4077, "최근 상품 삭제에 실패했습니다."),
    SEARCHHISTORY_RETRIEVE_FAILED(false, 4078, "최근 상품 검색어 조회에 실패했습니다."),
    SEARCHHISTORY_DELETE_FAILED(false, 4079, "최근 상품 검색어 삭제에 실패했습니다."),
    CATEGORYHISTORY_RETRIEVE_FAILED(false, 4080, "최근 카테고리 조회에 실패했습니다."),
    CATEGORYHISTORY_DELETE_FAILED(false, 4081, "최근 카테고리 삭제에 실패했습니다."),
    BRANDHISTORY_RETRIEVE_FAILED(false, 4082, "최근 브랜드 조회에 실패했습니다."),
    BRANDHISTORY_DELETE_FAILED(false, 4083, "최근 브랜드 삭제에 실패했습니다."),


    /**
     * 5000: S3 오류
     **/
    // Common
    TRANSLATE_FILE_FAILED(false, 5000, "파일 변환에 실패하였습니다."),


    /**
     * 6000: SMS 오류
     **/
    // Common
    OBJECT_TO_JSON_FAILED(false, 6000, "JSON 변환에 실패하였습니다."),
    CREATE_URI_FAILED(false, 6001, "URI 생성에 실패하였습니다."),
    CREATE_SIGNATURE_FAILED(false, 6002, "서명 생성에 실패하였습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;


    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
