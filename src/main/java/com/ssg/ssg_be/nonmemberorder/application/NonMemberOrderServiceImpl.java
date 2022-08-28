package com.ssg.ssg_be.nonmemberorder.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.nonmemberorder.domain.*;
import com.ssg.ssg_be.nonmemberorder.infrastructure.NonMemberOrderListRepository;
import com.ssg.ssg_be.nonmemberorder.infrastructure.NonMemberOrderRepository;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class NonMemberOrderServiceImpl implements NonMemberOrderService {

    private NonMemberOrderRepository nonMemberOrderRepository;
    private NonMemberOrderListRepository nonMemberOrderListRepository;
    private ProductOptionRepository productOptionRepository;

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
    public NonMemberOrderListDtoRes retrieveNonMemberOrders(Long orderId) throws BaseException {

        try {
            List<NonMemberOrderDtoRes> nonMemberOrderDtoRes = nonMemberOrderRepository.findAllByNonMemberOrderList_NonMemberOrderListId(orderId);
            NonMemberOrderList nonMemberOrderList = nonMemberOrderListRepository.getById(orderId);

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

    @Override
    public boolean authNonMember(NonMemberAuthDtoReq nonMemberAuthDtoReq) {
        return nonMemberOrderRepository.existsByNonMemberOrderList_NonMemberOrderListIdAndNonMemberOrderList_NameAndNonMemberOrderList_Phone(nonMemberAuthDtoReq.getNonMemberOrderListId(), nonMemberAuthDtoReq.getName(), nonMemberAuthDtoReq.getPhone());
    }

    @Override
    public void cancelNonMemberOrder(Long orderId) throws BaseException {
        NonMemberOrder nonMemberOrder = nonMemberOrderRepository.getById(orderId);

        if(nonMemberOrder.getOrderState() != 0) {
            throw new BaseException(UNABLE_TO_CANCEL_ORDER);
        }

        if(nonMemberOrder.getShippingState() == 0) {
            try {
                nonMemberOrderRepository.save(NonMemberOrder.builder()
                            .nonMemberOrderId(nonMemberOrder.getNonMemberOrderId())
                            .nonMemberOrderList(nonMemberOrder.getNonMemberOrderList())
                            .productOptionId(nonMemberOrder.getProductOptionId())
                            .count(nonMemberOrder.getCount())
                            .totalPayment(nonMemberOrder.getTotalPayment())
                            .orderState(1)
                            .shippingState(nonMemberOrder.getShippingState())
                            .courierCompany(nonMemberOrder.getCourierCompany())
                            .waybillNumber(nonMemberOrder.getWaybillNumber())
                            .build());

                ProductOption productOption = productOptionRepository.getById(nonMemberOrder.getProductOptionId());

                productOptionRepository.save(ProductOption.builder()
                        .productOptionId(productOption.getProductOptionId())
                        .product(productOption.getProduct())
                        .size(productOption.getSize())
                        .color(productOption.getColor())
                        .modelNumber(productOption.getModelNumber())
                        .stock(productOption.getStock()+nonMemberOrder.getCount())
                        .build());
            } catch (Exception exception) {
                throw new BaseException(ORDER_CANCEL_FAILED);
            }
        } else {
            throw new BaseException(ALREADY_BEING_PREPARED);
        }
    }

    @Override
    public void updateNonMemberOrder(Long orderId, int type) throws BaseException {
        NonMemberOrder nonMemberOrder = nonMemberOrderRepository.getById(orderId);
        LocalDateTime today = LocalDateTime.now();

        if(nonMemberOrder.getShippingState() == 5) {
            LocalDateTime arrivalDate = nonMemberOrder.getUpdateAt();
            LocalDateTime expiryDate = arrivalDate.plusDays(7);

            if(today.isAfter(expiryDate)) {
                throw new BaseException(OVERDUE_ORDER_CHANGE);
            }
        }

        if(nonMemberOrder.getOrderState() == 1 || nonMemberOrder.getOrderState() == 2 || nonMemberOrder.getOrderState() == 3) {
            throw new BaseException(UNABLE_TO_CHANGE_ORDER);
        }

        try {
            nonMemberOrderRepository.save(NonMemberOrder.builder()
                    .nonMemberOrderId(nonMemberOrder.getNonMemberOrderId())
                    .nonMemberOrderList(nonMemberOrder.getNonMemberOrderList())
                    .productOptionId(nonMemberOrder.getProductOptionId())
                    .count(nonMemberOrder.getCount())
                    .totalPayment(nonMemberOrder.getTotalPayment())
                    .orderState(type)
                    .shippingState(nonMemberOrder.getShippingState())
                    .courierCompany(nonMemberOrder.getCourierCompany())
                    .waybillNumber(nonMemberOrder.getWaybillNumber())
                    .build());
        } catch(Exception exception) {
            throw new BaseException(ORDER_CHANGE_FAILED);
        }
    }
}
