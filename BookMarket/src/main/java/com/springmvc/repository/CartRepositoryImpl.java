package com.springmvc.repository;


import com.springmvc.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository{

    private Map<String, Cart> listsofCarts;//장바구니 목록을 저장하는 HashMap

    public CartRepositoryImpl() {
        listsofCarts = new HashMap<String, Cart>();//객체가 생성될때 데이터를 초기화하고 시작
    }

    @Override
    public Cart create(Cart cart) {//새로운 장바구니를 생성하고 장바구니 id를 등록하고 생성된 장바구니 객체를 반환
        if (listsofCarts.keySet().contains(cart.getCartId())){//예외처리
            throw new IllegalArgumentException(String.format("장바구니를 생성할수 없습니다. 장바구니 id(%)가 존재합니다", cart.getCartId()));
        }
        listsofCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId)
    {//장바구니 Id를 이용하여 장바구니에 등록된 모든 정보를 가져와 반환
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

    @Override
    public void deleteAll(String cartId) {
        if(!listsofCarts.keySet().contains(cartId)){
            //장바구니 ID가 존재하지 않으면 예외처리
            throw new IllegalArgumentException(String.format("장바구니 목록을 삭제할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다", cartId));

        }
        listsofCarts.remove(cartId);
    }
}
