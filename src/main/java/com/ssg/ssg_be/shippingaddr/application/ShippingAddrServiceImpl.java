package com.ssg.ssg_be.shippingaddr.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoReq;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrDtoRes;
import com.ssg.ssg_be.shippingaddr.domain.ShippingAddrPutDtoReq;
import com.ssg.ssg_be.shippingaddr.infrastructure.ShippingAddrRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class ShippingAddrServiceImpl implements ShippingAddrService {

    private final ShippingAddrRepository shippingAddrRepository;
    private final UserRepository userRepository;

    @Autowired
    public ShippingAddrServiceImpl(ShippingAddrRepository shippingAddrRepository, UserRepository userRepository) {
        this.shippingAddrRepository = shippingAddrRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createShippingAddr(ShippingAddrDtoReq shippingAddrDtoReq) throws BaseException {

        User user = userRepository.getById(shippingAddrDtoReq.getUserId());

        try {
            shippingAddrRepository.save(shippingAddrDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_INSERT_FAILED);
        }
    }

    @Override
    public List<ShippingAddrDtoRes> retrieveShippingAddr(Long userId) throws BaseException {
        User user = userRepository.getById(userId);

        try {
            return shippingAddrRepository.findByUser(user);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_RETRIEVE_FAILED);
        }
    }

    @Override
    public void updateShippingAddr(ShippingAddrPutDtoReq shippingAddrPutDtoReq) throws BaseException {

        try {
            User user = userRepository.getById(shippingAddrPutDtoReq.getUserId());

            shippingAddrRepository.save(shippingAddrPutDtoReq.toEntity(user));
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_UPDATE_FAILED);
        }
    }

    @Override
    public void deleteShippingAddr(Long addrId) throws BaseException {

        try {
            shippingAddrRepository.deleteById(addrId);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DELETE_FAILED);
        }
    }
}
