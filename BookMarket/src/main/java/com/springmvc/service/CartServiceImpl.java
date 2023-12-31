package com.springmvc.service;

import com.springmvc.domain.Cart;
import com.springmvc.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.create(cart);//저장소 객체에서 생성한 장바구니를 가져와 반환
    }

    @Override
    public Cart read(String cartId) {
        return cartRepository.read(cartId);//저장소 객체에서 장바구니 ID에 대해 장바구니에 등록된
        // 모든 정보를 가져와 반환
    }

    @Override
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);

    }

    @Override
    public void deleteAll(String cartId) {
        cartRepository.deleteAll(cartId);
    }
}
