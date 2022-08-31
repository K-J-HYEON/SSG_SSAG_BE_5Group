package com.ssg.ssg_be.signup.presentation;

import com.ssg.ssg_be.signup.application.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(
        properties = {
                "testId=TC-001",
                "testName=사용자 회원가입"
        }
)
@Slf4j
@Transactional
class SignupControllerTest {

    @Autowired
    private SignupService signupService;

    @Value("${testId}")
    private String testId;

    @Value("${testName}")
    private String testName;

    @Test
    void addUser() throws Exception {
        log.info("testId : " + testId);
        log.info("testName : " + testName);
    }
}