package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.domain.MemberInfoPutDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private UserRepository userRepository;
    private Long userId;

    @Autowired
    public MemberInfoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MemberInfoDtoRes retrieveUserMember(Long userId) throws BaseException {
        try {
            return userRepository.findById(userId).get().toDto();
        } catch (Exception exception) {
            throw new BaseException(USER_RETRIEVE_FAILED);
        }
    }

    @Override
    public void updateUserMember(MemberInfoPutDtoReq memberInfoPutDtoReq) throws BaseException {
        try {
            User user = userRepository.findByUserId(memberInfoPutDtoReq.getUserId()).orElseThrow(() ->
                new BaseException(USER_RETRIEVE_FAILED)
            );
            userRepository.save(memberInfoPutDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(USER_UPDATE_FAILED);
        }
    }
}
