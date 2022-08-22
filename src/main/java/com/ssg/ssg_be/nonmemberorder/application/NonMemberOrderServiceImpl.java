package com.ssg.ssg_be.nonmemberorder.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.nonmemberorder.domain.*;
import com.ssg.ssg_be.nonmemberorder.infrastructure.NonMemberOrderListRepository;
import com.ssg.ssg_be.nonmemberorder.infrastructure.NonMemberOrderRepository;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class NonMemberOrderServiceImpl implements NonMemberOrderService {

    private final NonMemberOrderRepository nonMemberOrderRepository;
    private final NonMemberOrderListRepository nonMemberOrderListRepository;
    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public NonMemberOrderServiceImpl(NonMemberOrderRepository nonMemberOrderRepository, NonMemberOrderListRepository nonMemberOrderListRepository, ProductOptionRepository productOptionRepository) {
        this.nonMemberOrderRepository = nonMemberOrderRepository;
        this.nonMemberOrderListRepository = nonMemberOrderListRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public NonMemberOrderIdDtoRes createNonMemberOrders(NonMemberOrderListDtoReq nonMemberOrderListDtoReq) throws BaseException {
        Long orderId;

        try {
            NonMemberOrderList nonMemberOrderList = nonMemberOrderListRepository.save(nonMemberOrderListDtoReq.toEntity());
            nonMemberOrderListDtoReq.getOrderDtoReq().forEach(orderDtoReq -> nonMemberOrderRepository.save(orderDtoReq.toEntity(nonMemberOrderList)));
            orderId = nonMemberOrderList.getNonMemberOrderListId();
        } catch (Exception exception) {
            throw new BaseException(ORDER_INSERT_FAILED);
        }

        try {
            for(NonMemberOrderDtoReq nonMemberOrderDtoReq : nonMemberOrderListDtoReq.getOrderDtoReq()) {
                ProductOption productOption = productOptionRepository.getById(nonMemberOrderDtoReq.getProductOptionId());

                if(productOption.getStock()-nonMemberOrderDtoReq.getCount() < 0) {
                    throw new BaseException(OUT_OF_STOCK);
                }

                productOptionRepository.save(ProductOption.builder()
                        .productOptionId(productOption.getProductOptionId())
                        .product(productOption.getProduct())
                        .size(productOption.getSize())
                        .color(productOption.getColor())
                        .modelNumber(productOption.getModelNumber())
                        .stock(productOption.getStock()-nonMemberOrderDtoReq.getCount())
                        .build());
            }
        } catch (Exception exception) {
            throw new BaseException(REDUCE_STOCK_FAILED);
        }

        return new NonMemberOrderIdDtoRes(orderId);
    }

    @Override
    public NonMemberOrderListDtoRes retrieveNonMemberOrders(NonMemberGetOrderDtoReq nonMemberGetOrderDtoReq) throws BaseException {

        if(!nonMemberOrderRepository.existsByNonMemberOrderList_NonMemberOrderListIdAndNonMemberOrderList_NameAndNonMemberOrderList_Phone(nonMemberGetOrderDtoReq.getNonMemberOrderListId(), nonMemberGetOrderDtoReq.getName(), nonMemberGetOrderDtoReq.getPhone())) {
            throw new BaseException(NO_LOOKUP_VALUE);
        }

        try {
            List<NonMemberOrderDtoRes> nonMemberOrderDtoRes = nonMemberOrderRepository.findAllByNonMemberOrderList_NonMemberOrderListId(nonMemberGetOrderDtoReq.getNonMemberOrderListId());
            NonMemberOrderList nonMemberOrderList = nonMemberOrderListRepository.getById(nonMemberGetOrderDtoReq.getNonMemberOrderListId());

            return NonMemberOrderListDtoRes.builder()
                    .name(nonMemberOrderList.getName())
                    .phone(nonMemberOrderList.getPhone())
                    .email(nonMemberOrderList.getEmail())
                    .streetAddr(nonMemberOrderList.getStreetAddr())
                    .zipCode(nonMemberOrderList.getZipCode())
                    .shippingMsg(nonMemberOrderList.getShippingMsg())
                    .createAt(nonMemberOrderList.getCreateAt())
                    .orders(nonMemberOrderDtoRes)
                    .build();
        } catch (Exception exception) {
            throw new BaseException(ORDER_RETRIEVE_FAILED);
        }
    }
}
