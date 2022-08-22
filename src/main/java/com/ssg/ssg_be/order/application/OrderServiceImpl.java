package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.order.domain.OrderDtoReq;
import com.ssg.ssg_be.order.domain.OrderList;
import com.ssg.ssg_be.order.domain.OrderListDtoReq;
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
}
