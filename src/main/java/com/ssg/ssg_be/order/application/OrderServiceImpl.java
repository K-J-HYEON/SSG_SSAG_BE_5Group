package com.ssg.ssg_be.order.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.order.domain.OrderList;
import com.ssg.ssg_be.order.domain.OrderListDtoReq;
import com.ssg.ssg_be.order.infrastructure.OrderListRepository;
import com.ssg.ssg_be.order.infrastructure.OrderRepository;
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

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderListRepository orderListRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public void createOrder(OrderListDtoReq orderListDtoReq, Long userId) throws BaseException {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new BaseException(USER_RETRIEVE_FAILED));

        if(orderListDtoReq.getOrderDtoReq() == null) {
            log.info("null입니다.");
        }

        try {
            OrderList orderList = orderListRepository.save(orderListDtoReq.toEntity(user));
            orderListDtoReq.getOrderDtoReq().forEach(orderDtoReq -> orderRepository.save(orderDtoReq.toEntity(orderList)));
        } catch (Exception exception) {
            throw new BaseException(ORDER_INSERT_FAILED);
        }

        if(orderListDtoReq.getCartId() != null) {
            try {
                cartRepository.deleteAllById(orderListDtoReq.getCartId());
            } catch (Exception exception) {
                throw new BaseException(CART_DELETE_FAILED);
            }
        }
    }

    //TODO #1 : 장바구니 주문인 경우, 주문 성공 이후 cartId를 장바구니에서 삭제
    //TODO #2 : 바로 구매인 경우, OrderListDtoReq의 OrderDtoReq에서 데이터 가져오기
    //TODO #3 : 구매 수량만큼 제품 재고 줄이기 => 어느 시점에서 처리할지 고려
}
