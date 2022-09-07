package com.ssg.ssg_be;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.signup.application.SignupService;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.dto.UserDtoReq;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SsgBeApplicationTests {

	@Autowired
	SignupService signupService;
	@Autowired
	UserRepository userRepository;

	@Test
	@Order(1)
	@DisplayName("회원 가입")
	void signupTest() {
		//given
		String loginId = "testId10";
		String loginPwd = "testPwd10";
		String name = "테스터";
		String email = "testemail10@gmail.com";
		String phone = "010-1010-1010";
		UserDtoReq userDtoReq = UserDtoReq.builder()
				.loginId(loginId)
				.loginPwd(loginPwd)
				.name(name)
				.email(email)
				.phone(phone)
				.build();

		//when
		try {
			signupService.addUser(userDtoReq);
		} catch (BaseException e) {
			throw new RuntimeException(e);
		}

		//then
		User user = userRepository.findByEmail(userDtoReq.getEmail()).orElse(null);
		assertNotNull(user.getUserId());
		assertEquals(userDtoReq.getLoginId(), user.getLoginId());
		assertEquals(userDtoReq.getName(), user.getName());
		assertEquals(userDtoReq.getEmail(), user.getEmail());
		assertEquals(userDtoReq.getPhone(), user.getPhone());
	}

}
