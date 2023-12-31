package com.springmvc.service;

import com.springmvc.domain.Cart;

public interface CartService {//서비스 계층 구현
    Cart create(Cart cart);
    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void deleteAll(String cartId);
}
