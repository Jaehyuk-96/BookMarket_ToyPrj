package com.springmvc.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

        private String cartId;                  //장바구니 ID
        private Map<String, CartItem> cartItems;//장바구니 항목
        private int grandTotal;                 //총액

    public Cart() {//생성자 초기화
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
        grandTotal = 0;//초기화
        for (CartItem item : cartItems.values())  {//향상된for문으로 cartitem을 가져와서 item으로 꺼냄
            grandTotal = grandTotal + item.getTotalPrice();//item의 총합가격을 더해서 grandtotal 계산
        }
   }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else if (!cartId.equals(other.cartId))
            return false;
        return true;
    }

    public void addCartItem(CartItem item){
        String bookId = item.getBook().getBookId(); //등록할 도서 가져오기

        //도서 ID가 cartItems 객체에 있는지 여부 확인
        if(cartItems.containsKey(bookId)) {
            CartItem cartItem = cartItems.get(bookId);//등록된 도서 id에 대한 정보가져오기
            //등록된 도서 id의 개수 추가저장
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
            cartItems.put(bookId, cartItem); //기존에 이미 존재하는 bookId에 대한 정보를 업데이트
        }else{
            cartItems.put(bookId, item);// 도서 id에 대한 도서 정보(item) 저장 새로운 항목으로
        }
        updateGrandTotal();//총액 갱신
    }

    public void removeCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();//bookId 가져오기
        cartItems.remove(bookId);//bookdId 도서 삭제
        updateGrandTotal(); //총액 갱신
    }
}
