package com.springmvc.repository;

import com.springmvc.domain.Cart;

public interface CartRepository {//퍼시스턴트 계층 구현
    Cart create(Cart cart);
    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void deleteAll(String CartId);
}
