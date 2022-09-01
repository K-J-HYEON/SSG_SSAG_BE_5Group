package com.ssg.ssg_be.cart.application;

import com.ssg.config.BaseException;
import com.ssg.ssg_be.cart.domain.*;
import com.ssg.ssg_be.cart.infrastructure.CartRepository;
import com.ssg.ssg_be.product.domain.*;
import com.ssg.ssg_be.product.infrastructure.ProductOptionRepository;
import com.ssg.ssg_be.signup.domain.User;
import com.ssg.ssg_be.signup.infrastucture.UserRepository;
import com.ssg.ssg_be.store.domain.StoreIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ProductOptionRepository productOptionRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public boolean createCart(CartDtoReq cartDtoReq, Long userId) throws BaseException {
        User user = userRepository.findByUserId(userId).orElseThrow(()->new BaseException(NO_EXIST_USER));
        boolean isOverlap = false;

        try {
            ProductOption productOption;

            for(CartListDto cartListDto : cartDtoReq.getCartList()) {
                productOption = productOptionRepository.getById(cartListDto.getProductOptionId());

                // 장바구니에 해당 옵션이 이미 존재하는 경우, 수량만 더해 줌. 존재하지 않는 경우는 해당 옵션을 장바구니에 새로 추가
                if(cartRepository.existsByUserUserIdAndProductOption_ProductOptionId(userId, cartListDto.getProductOptionId())) {
                    Cart cart = cartRepository.findByUserUserIdAndProductOption_ProductOptionId(userId, cartListDto.getProductOptionId());

                    cartListDto.setCount(cartListDto.getCount()+cart.getCount());
                    cartRepository.save(cartListDto.toOriginEntity(user, productOption, cart.getCartId()));
                    isOverlap = true;
                } else {
                    cartRepository.save(cartListDto.toEntity(user, productOption));
                }
            }
        } catch (Exception exception) {
            throw new BaseException(CART_INSERT_FAILED);
        }

        return isOverlap;
    }

    @Override
    public CartTotalDtoRes retrieveCart(Long userId) throws BaseException {

        try {
            // 장바구니 각 아이템의 스토어 ID 추출
            List<StoreIdDto> storeIdDtos = cartRepository.findAllByUserUserId(userId);
            Map<Long, String> map = new HashMap<>();
            int totalOrder = 0;
            int totalSale = 0;
            int totalAmount = 0;

            for(StoreIdDto storeIdDto : storeIdDtos) {
                map.put(storeIdDto.getProductOptionProductStoreStoreId(), storeIdDto.getProductOptionProductStoreName());
            }

            List<StoreList> storeLists = new ArrayList<>();
            for(Long s : map.keySet()){
                int storeTotal = 0;
                int storeSale = 0;
                int storeAmount = 0;
                List<Cart> carts = cartRepository.getCartsByStore(userId, s);
                List<CartList> cartLists = new ArrayList<>();

                for(Cart cart : carts) {
                    ProductOption productOption = cart.getProductOption();
                    Product product = productOption.getProduct();
                    int cartTotal = cart.getCount() * product.getPrice();
                    int cartSale = (int) (product.getPrice() * (product.getSale() * 0.01)) * cart.getCount();
                    int cartAmount = cartTotal - cartSale;

                    ProductDto productDto = ProductDto.builder()
                            .productId(product.getProductId())
                            .name(product.getName())
                            .price(product.getPrice())
                            .sale(product.getSale())
                            .imgUrl(product.getImgUrl())
                            .build();

                    ProductOptionDto productOptionDto = ProductOptionDto.builder()
                            .productOptionId(productOption.getProductOptionId())
                            .sizeId(productOption.getSize().getSizeId())
                            .size(productOption.getSize().getSize())
                            .colorId(productOption.getColor().getColorId())
                            .color(productOption.getColor().getColor())
                            .modelNumber(productOption.getModelNumber())
                            .stock(productOption.getStock())
                            .productDto(productDto)
                            .build();

                    cartLists.add(
                            CartList.builder()
                                    .cartId(cart.getCartId())
                                    .count(cart.getCount())
                                    .cartTotal(cartTotal)
                                    .cartSale(cartSale)
                                    .cartAmount(cartAmount)
                                    .productOptionDto(productOptionDto)
                                    .build()
                    );

                    storeTotal += cartTotal;
                    storeSale += cartSale;
                    storeAmount += cartAmount;
                }

                storeLists.add(StoreList.builder()
                                .storeId(s)
                                .storeName(map.get(s))
                                .storeTotal(storeTotal)
                                .storeSale(storeSale)
                                .storeAmount(storeAmount)
                                .cartList(cartLists)
                        .build());

                totalOrder += storeTotal;
                totalSale += storeSale;
                totalAmount += storeAmount;
            }

            return CartTotalDtoRes.builder()
                    .totalOrder(totalOrder)
                    .totalSale(totalSale)
                    .totalAmount(totalAmount)
                    .storeList(storeLists)
                    .build();
        } catch (Exception exception) {
            throw new BaseException(CART_RETRIEVE_FAILED);
        }
    }

    @Override
    public void deleteCart(Long cartId) throws BaseException {
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception exception) {
            throw new BaseException(CART_DELETE_FAILED);
        }
    }

    @Override
    public void updateCartCount(CartCountPatchDtoReq cartCountPatchDtoReq) throws BaseException {
        try {
            Cart cart = cartRepository.getById(cartCountPatchDtoReq.getCartId());

            cartRepository.save(cartCountPatchDtoReq.toEntity(cart.getUser(), cart.getProductOption()));

        } catch (Exception exception) {
            throw new BaseException(CART_COUNT_UPDATE_FAILED);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public CartOptionPatchDtoRes updateCartOption(CartOptionPatchDtoReq cartOptionPatchDtoReq, Long userId) throws BaseException {
        Cart cart = cartRepository.getById(cartOptionPatchDtoReq.getCartId());

        ProductOption newProductOption;
        try {
            newProductOption = productOptionRepository.getById(cartOptionPatchDtoReq.getProductOptionId());
        } catch(Exception exception) {
            throw new BaseException(OPTION_RETRIEVE_FAILED);
        }

        ProductOptionDtoRes productOptionDtoRes = ProductOptionDtoRes.builder()
                .productOptionId(newProductOption.getProductOptionId())
                .size(newProductOption.getSize())
                .color(newProductOption.getColor())
                .modelNumber(newProductOption.getModelNumber())
                .stock(newProductOption.getStock())
                .build();

        try {
            if(cartRepository.existsByUserUserIdAndProductOption_ProductOptionId(userId, newProductOption.getProductOptionId())) {
                Cart overlapCart = cartRepository.findByUserUserIdAndProductOption_ProductOptionId(userId, newProductOption.getProductOptionId());

                cartRepository.save(Cart.builder()
                            .cartId(overlapCart.getCartId())
                            .productOption(newProductOption)
                            .user(overlapCart.getUser())
                            .count(overlapCart.getCount()+cart.getCount())
                            .build());

                cartRepository.deleteById(cart.getCartId());
                return new CartOptionPatchDtoRes(overlapCart.getCartId(), productOptionDtoRes, overlapCart.getCount()+cart.getCount());

            } else {
                cartRepository.save(Cart.builder()
                            .cartId(cartOptionPatchDtoReq.getCartId())
                            .productOption(newProductOption)
                            .user(cart.getUser())
                            .count(cart.getCount())
                            .build());
                return new CartOptionPatchDtoRes(cartOptionPatchDtoReq.getCartId(), productOptionDtoRes, cart.getCount());
            }
        } catch(Exception exception) {
            throw new BaseException(CART_OPTION_UPDATE_FAILED);
        }
    }

    @Override
    public CartCountDto retrieveCartCount(Long userId) throws BaseException {
        try {
            int cartCount = cartRepository.retrieveCartCount(userId);
            return new CartCountDto(cartCount);
        } catch (Exception exception) {
            throw new BaseException(CART_RETRIEVE_FAILED);
        }
    }
}
