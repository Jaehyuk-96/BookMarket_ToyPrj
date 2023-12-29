package com.springmvc.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

        private String cartId;
        private Map<String, CartItem> cartItems;
        private int grandTotal;

    public Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

   public void updateGrandTotal() {
        grandTotal = 0;
        for (CartItem item : cartItems.values())  {
            grandTotal = grandTotal + item.getTotalPrice();
        }
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(getClass() != o.getClass())
            return false;
        Cart other = (Cart) o;
        if (cartId == null){
            if(other.cartId != null)
                return false;
        }else if (!cartId.equals(other.cartId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;;
        result = prime * result + ((cartId == null) ?  0 : cartId.hashCode());
        return result;
    }

    public void addCartItem(CartItem item){
        String bookId = item.getBook().getBookId(); //등록할 도서 가져오기

        //도서 ID가 cartItems 객체에 있는지 여부 확인
        if(cartItems.containsKey(bookId)) {
            CartItem cartItem = cartItems.get(bookId);//등록된 도서 id에 대한 정보가져오기
            //등록된 도서 id의 개수 추가저장
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
        }else{
            cartItems.put(bookId, item);// 도서 id에 대한 도서 정보(item) 저장
        }
        updateGrandTotal();//총액 갱신
    }
}
