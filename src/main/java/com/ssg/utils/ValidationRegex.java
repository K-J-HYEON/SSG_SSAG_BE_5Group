package com.ssg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRegex {

    /**
     * SMS 인증 -> 휴대폰번호 정규식
     * ex) 01012345678
     */
    public static boolean isRegexPhone(String target) {
        String regex = "^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

}
