package com.ssg.ssg_be.shippingaddr.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.shippingaddr.domain.*;
import com.ssg.ssg_be.shippingaddr.infrastructure.ShippingAddrRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void createShippingAddr(ShippingAddrDtoReq shippingAddrDtoReq, Long userId) throws BaseException {

        User user = userRepository.getById(userId);
        int addrDefault = 0;

        if(!shippingAddrRepository.existsByUserUserId(userId) || !shippingAddrRepository.existsByAddrDefault(1)) {
            addrDefault = 1;
        }

        try {
            shippingAddrRepository.save(shippingAddrDtoReq.toEntity(user, addrDefault));
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_INSERT_FAILED);
        }
    }

    @Override
    public List<ShippingAddrDtoRes> retrieveShippingAddr(Long userId) throws BaseException {

        try {
            return shippingAddrRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_RETRIEVE_FAILED);
        }
    }

    @Override
    public ShippingAddrDtoRes retrieveBasicShippingAddr(Long userId) throws BaseException {
        try {
            return shippingAddrRepository.findByUserUserIdAndAddrDefault(userId, 1);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_RETRIEVE_FAILED);
        }
    }

    @Override
    public void updateShippingAddr(ShippingAddrPutDtoReq shippingAddrPutDtoReq, Long userId) throws BaseException {

        try {
            User user = userRepository.getById(userId);
            ShippingAddr shippingAddr = shippingAddrRepository.getById(shippingAddrPutDtoReq.getAddrId());

            shippingAddrRepository.save(shippingAddrPutDtoReq.toEntity(user, shippingAddr.getAddrDefault()));
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_UPDATE_FAILED);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public void updateDefaultShippingAddr(ShippingAddrDefaultPutDtoReq shippingAddrDefaultPutDtoReq, Long userId) throws BaseException {

        User user = userRepository.getById(userId);

        try {
            ShippingAddrDtoRes originAddr = shippingAddrRepository.findByUserUserIdAndAddrDefault(userId, 1);
            shippingAddrRepository.save(ShippingAddr.builder()
                    .addrId(originAddr.getAddrId())
                    .user(user)
                    .addrName(originAddr.getAddrName())
                    .recipient(originAddr.getRecipient())
                    .phone(originAddr.getPhone())
                    .homePhone(originAddr.getHomePhone())
                    .zipCode(originAddr.getZipCode())
                    .streetAddr(originAddr.getStreetAddr())
                    .lotAddr(originAddr.getLotAddr())
                    .addrDefault(0)
                    .build());
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DEFAULT_UPDATE_FAILED);
        }

        ShippingAddr newAddr = shippingAddrRepository.findById(shippingAddrDefaultPutDtoReq.getAddrId()).orElseThrow(()->new BaseException(NO_LOOKUP_VALUE));

        try {
            shippingAddrRepository.save(ShippingAddr.builder()
                    .addrId(newAddr.getAddrId())
                    .user(newAddr.getUser())
                    .addrName(newAddr.getAddrName())
                    .recipient(newAddr.getRecipient())
                    .phone(newAddr.getPhone())
                    .homePhone(newAddr.getHomePhone())
                    .zipCode(newAddr.getZipCode())
                    .streetAddr(newAddr.getStreetAddr())
                    .lotAddr(newAddr.getLotAddr())
                    .addrDefault(1)
                    .build());
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DEFAULT_UPDATE_FAILED);
        }

    }

    @Override
    public void deleteShippingAddr(Long addrId) throws BaseException {

        ShippingAddr shippingAddr = shippingAddrRepository.getById(addrId);
        Long userId = shippingAddr.getUser().getUserId();
        int addrDefault = shippingAddr.getAddrDefault();

        try {
            shippingAddrRepository.deleteById(addrId);
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DELETE_FAILED);
        }

        try {
            if(addrDefault == 1 && shippingAddrRepository.existsByUserUserId(userId)) {
                List<ShippingAddr> newDefaultAddr = shippingAddrRepository.findByUserUserId(userId);

                shippingAddrRepository.save(ShippingAddr.builder()
                        .addrId(newDefaultAddr.get(0).getAddrId())
                        .user(newDefaultAddr.get(0).getUser())
                        .addrName(newDefaultAddr.get(0).getAddrName())
                        .recipient(newDefaultAddr.get(0).getRecipient())
                        .phone(newDefaultAddr.get(0).getPhone())
                        .homePhone(newDefaultAddr.get(0).getHomePhone())
                        .zipCode(newDefaultAddr.get(0).getZipCode())
                        .streetAddr(newDefaultAddr.get(0).getStreetAddr())
                        .lotAddr(newDefaultAddr.get(0).getLotAddr())
                        .addrDefault(1)
                        .build());
            }
        } catch (Exception exception) {
            throw new BaseException(SHIPPING_ADDR_DEFAULT_UPDATE_FAILED);
        }
    }
}
