package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.order.domain.*;
import com.ssg.ssg_be.order.infrastructure.OrderListRepository;
import com.ssg.ssg_be.order.infrastructure.OrderRepository;
import com.ssg.ssg_be.product.domain.ProductOption;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderListRepository orderListRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderListRepository orderListRepository, UserRepository userRepository, CartRepository cartRepository, ProductOptionRepository productOptionRepository) {
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public void createOrder(OrderListDtoReq orderListDtoReq, Long userId) throws BaseException {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new BaseException(USER_RETRIEVE_FAILED));

        try {
            OrderList orderList = orderListRepository.save(orderListDtoReq.toEntity(user));
            orderListDtoReq.getOrderDtoReq().forEach(orderDtoReq -> orderRepository.save(orderDtoReq.toEntity(orderList)));
        } catch (Exception exception) {
            throw new BaseException(ORDER_INSERT_FAILED);
        }

        try {
            for(OrderDtoReq orderDtoReq : orderListDtoReq.getOrderDtoReq()) {
                ProductOption productOption = productOptionRepository.getById(orderDtoReq.getProductOptionId());

                if(productOption.getStock()-orderDtoReq.getCount() < 0) {
                    throw new BaseException(OUT_OF_STOCK);
                }

                productOptionRepository.save(ProductOption.builder()
                        .productOptionId(productOption.getProductOptionId())
                        .product(productOption.getProduct())
                        .size(productOption.getSize())
                        .color(productOption.getColor())
                        .modelNumber(productOption.getModelNumber())
                        .stock(productOption.getStock()-orderDtoReq.getCount())
                        .build());
            }
        } catch (Exception exception) {
            throw new BaseException(REDUCE_STOCK_FAILED);
        }

        if(orderListDtoReq.getCartId() != null) {
            try {
                cartRepository.deleteAllById(orderListDtoReq.getCartId());
            } catch (Exception exception) {
                throw new BaseException(CART_DELETE_FAILED);
            }
        }
    }

    @Override
    public List<OrderDtoListRes> retrieveOrders(Long userId) throws BaseException {

        try {
            return orderListRepository.findAllByUserUserId(userId);
        } catch (Exception exception) {
            throw new BaseException(ORDER_RETRIEVE_FAILED);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public void cancelOrder(OrderUpdateDtoReq updateDtoReq) throws BaseException {

        Orders order = orderRepository.getById(updateDtoReq.getOrderId());

        if(order.getOrderState() != 0) {
            throw new BaseException(UNABLE_TO_CANCEL_ORDER);
        }

        if(order.getShippingState() == 0) {
            try {
                orderRepository.save(Orders.builder()
                                .orderId(order.getOrderId())
                                .orderList(order.getOrderList())
                                .productOptionId(order.getProductOptionId())
                                .count(order.getCount())
                                .totalPayment(order.getTotalPayment())
                                .orderState(1)
                                .shippingState(order.getShippingState())
                                .courierCompany(order.getCourierCompany())
                                .waybillNumber(order.getWaybillNumber())
                                .build());

                ProductOption productOption = productOptionRepository.getById(order.getProductOptionId());

                productOptionRepository.save(ProductOption.builder()
                                .productOptionId(productOption.getProductOptionId())
                                .product(productOption.getProduct())
                                .size(productOption.getSize())
                                .color(productOption.getColor())
                                .modelNumber(productOption.getModelNumber())
                                .stock(productOption.getStock()+order.getCount())
                                .build());
            } catch (Exception exception) {
                throw new BaseException(ORDER_CANCEL_FAILED);
            }
        } else {
            throw new BaseException(ALREADY_BEING_PREPARED);
        }
    }

    @Override
    public void updateOrder(OrderUpdateDtoReq updateDtoReq, Long userId, int type) throws BaseException {

        Orders order = orderRepository.getById(updateDtoReq.getOrderId());
        LocalDateTime today = LocalDateTime.now();

        if(order.getShippingState() == 5) {
            LocalDateTime arrivalDate = order.getUpdateAt();
            LocalDateTime expiryDate = arrivalDate.plusDays(7);

            if(today.isAfter(expiryDate)) {
                throw new BaseException(OVERDUE_ORDER_CHANGE);
            }
        }

        if(order.getOrderState() == 1 || order.getOrderState() == 2 || order.getOrderState() == 3) {
            throw new BaseException(UNABLE_TO_CHANGE_ORDER);
        }

        try {
            orderRepository.save(Orders.builder()
                    .orderId(order.getOrderId())
                    .orderList(order.getOrderList())
                    .productOptionId(order.getProductOptionId())
                    .count(order.getCount())
                    .totalPayment(order.getTotalPayment())
                    .orderState(type)
                    .shippingState(order.getShippingState())
                    .courierCompany(order.getCourierCompany())
                    .waybillNumber(order.getWaybillNumber())
                    .build());
        } catch(Exception exception) {
            throw new BaseException(ORDER_CHANGE_FAILED);
        }

    }

    @Override
    public void deleteOrder(Long orderId) throws BaseException {
        try {
            Orders order = orderRepository.getById(orderId);

            if(order.getOrderState() == 4 && order.getShippingState() == 5) {
                orderRepository.deleteById(orderId);
            } else {
                throw new BaseException(ORDER_DELETE_FAILED);
            }
        } catch (Exception exception) {
            throw new BaseException(ORDER_DELETE_FAILED);
        }
    }
}
