package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.UserMemberInfoPutDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class UserMemberInfoServiceImpl implements UserMemberInfoService {

    private UserRepository userRepository;
    private Long userId;

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

    @Override
    public void updateUserMember(UserMemberInfoPutDtoReq userMemberInfoPutDtoReq) throws BaseException {
        try {
            User user = userRepository.findByUserId(userMemberInfoPutDtoReq.getUserId()).orElseThrow(() ->
                new BaseException(USER_RETRIEVE_FAILED)
            );
            userRepository.save(userMemberInfoPutDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(USER_UPDATE_FAILED);
        }
    }
}
