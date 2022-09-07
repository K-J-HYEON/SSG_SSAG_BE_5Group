package com.ssg.utils.oauth;

import com.ssg.config.Role;
import com.ssg.ssg_be.signup.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String username;
    private String email;
    private String mobile;
    private Role role;

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        if ("kakao".equals(registrationId)) {
            return ofKakao("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .username(String.valueOf(attributes.get("name")))
                .email(String.valueOf(attributes.get("email")))
                .mobile(String.valueOf(attributes.get("mobile")))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .username(String.valueOf(response.get("name")))
                .email(String.valueOf(response.get("email")))
                .mobile(String.valueOf(response.get("mobile")))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakao_profile = (Map<String, Object>) kakao_account.get("profile");

        return OAuthAttributes.builder()
                .username(String.valueOf(kakao_profile.get("nickname")))
                .email(String.valueOf(kakao_account.get("email")))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity(int userType) {
        return User.builder()
                .name(username)
                .email(email)
                .phone(mobile)
                .loginDate(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .userType(userType)
                .userRole(Role.USER)
                .build();
    }
}
