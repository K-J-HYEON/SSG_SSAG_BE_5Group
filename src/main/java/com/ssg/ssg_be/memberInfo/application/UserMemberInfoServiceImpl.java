package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class UserMemberInfoServiceImpl implements UserMemberInfoService {

    private UserRepository userRepository;

    @Autowired
    public UserMemberInfoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserMemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException {
        try {
            return userRepository.findById(userId).get().toDto();
        } catch (Exception exception) {
            throw new BaseException(USER_RETRIEVE_FAILED);
        }
    }
}
