package com.ssg.ssg_be.memberInfo.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.memberInfo.dto.MemberInfoDtoRes;
import com.ssg.ssg_be.memberInfo.dto.MemberInfoPutDtoReq;
import com.ssg.ssg_be.memberInfo.dto.MemberUpdatePasswordDtoReq;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberInfoServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public void updateUserMember(MemberInfoPutDtoReq memberInfoPutDtoReq, Long userId) throws BaseException {
        try {
            User user = userRepository.findByUserId(userId).orElseThrow(() ->
                    new BaseException(USER_RETRIEVE_FAILED)
            );
            userRepository.save(memberInfoPutDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(USER_UPDATE_FAILED);
        }
    }

    @Override
    public void updateUserPassword(MemberUpdatePasswordDtoReq memberUpdatePasswordDtoReq, Long userId) throws BaseException {
        try {
            User user = userRepository.findByUserId(userId).orElseThrow(() ->
                    new BaseException(PASSWORD_RETRIEVE_FAILED)
            );

            memberUpdatePasswordDtoReq.setNewPassword(bCryptPasswordEncoder.encode(memberUpdatePasswordDtoReq.getNewPassword()));
            userRepository.save(memberUpdatePasswordDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(PASSWORD_UPDATE_FAILED);
        }
    }
}
