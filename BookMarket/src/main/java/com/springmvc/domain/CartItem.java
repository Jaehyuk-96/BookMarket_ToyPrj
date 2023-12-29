package com.springmvc.domain;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class CartItem {
    private Book book;      //도서
    private int quantity;   //도서개수
    private int totalPrice; //도서가격

    public CartItem(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public int getTotalPrice(){
        return totalPrice;
    }


    private void updateTotalPrice() {
        totalPrice = this.book.getUnitPrice() * this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        CartItem other = (CartItem) o;
        if(book == null){
            if(other.book != null)
                return false;
        }else if(!book.equals(other.book))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ?  0 : book.hashCode());
        return result;
    }
}


