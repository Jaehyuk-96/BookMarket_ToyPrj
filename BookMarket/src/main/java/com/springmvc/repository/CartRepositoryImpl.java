package com.springmvc.repository;


import com.springmvc.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository{

    private Map<String, Cart> listsofCarts;

    public CartRepositoryImpl() {
        listsofCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        //장바구니 생성
        if (listsofCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("장바구니를 생성할수 없습니다. 장바구니 id(%)가 존재합니다", cart.getCartId()));
        }
        listsofCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId)
    {//장바구니 읽어오기
        return listsofCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {//장바구니 업데이트
        if(!listsofCarts.keySet().contains(cartId)) {
            //장바구니 ID가 존재하지 않는 경우 예외처리
            throw new IllegalStateException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다.", cartId));
        }
        listsofCarts.put(cartId, cart);
    }
}
