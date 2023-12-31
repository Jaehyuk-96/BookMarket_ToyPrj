package com.springmvc.controller;


import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/cart")
public class CartController {

    @Autowired
    private CartService cartService;//CartService객체 의존성 주입

    @Autowired
    private BookService bookService;//BookService객체 의존성 주입

    @GetMapping
    public String requestCartId(HttpServletRequest request) {//세션 ID 값을 가져와서 cart/sessionid로 리다이렉트함
        String sessionid = request.getSession(true).getId();
        return "redirect:/cart/" + sessionid;
    }

    @PostMapping
    public @ResponseBody Cart create(@RequestBody Cart cart){//Cart 클래스의 정보를 Http 요청 body로 전달받아 장바구니를 새로
        // 생성하고 Http 응답 body로 전달
        return cartService.create(cart);
    }

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value="cartId") String cartId, Model model) {//요청 url에서
        // 경로변수 cartId(장바구니ID)에 대해 장바구니에 등록된 모든 정보를 읽어와 커맨드 객체 CART에 등록하고 car.jsp로 포워드
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart",cart);
        return "cart";
    }

    @PutMapping("/{cartId}")//리소스 변경시 PutMapping사용
    public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId) {//요청 url에서 경로 변수인
        //장바구니 id(cartid)에 대해 장바구니에 등록된 모든 정보를 가져옴
        return cartService.read(cartId);
    }

    @PutMapping("/add/{bookId}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)//오류 응답상태 코드 설정
    public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request){
        //장바구니 id인 세션id 가져오기
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);//장바구니에 등록된 정보 세션아이디로 해서 얻어오기
        if(cart == null)
            cart = cartService.create(new Cart(sessionId));//장바구니가 비어있으면 새롭게 sessionId로 새 장바구니만들기
        //경로변수 bookId에 대한 정보 얻어오기
        Book book = bookService.getBookById(bookId);
        if(book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        //bookId가 없을시 예외 출력
        cart.addCartItem(new CartItem(book));//bookId에대한 도서 정보를 장바구니에 등록
        cartService.update(sessionId, cart);//세션 id에대한 장바구니 갱신하기
    }


    @PutMapping("/remove/{bookId}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)//오류 응답상태 코드 설정
    public void removeCartByItem(@PathVariable String bookId, HttpServletRequest request){
        //장바구니 id인 세션id 가져오기
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);//장바구니에 등록된 정보 세션아이디로 해서 얻어오기
        if(cart == null)
            cart = cartService.create(new Cart(sessionId));
        //경로변수 bookId에 대한 정보 얻어오기
        Book book = bookService.getBookById(bookId);
        if(book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        //bookId가 없을시 예외 출력
        cart.removeCartItem(new CartItem(book));//bookId에대한 도서 정보를 장바구니에 등록
        cartService.update(sessionId, cart);//세션 id에대한 장바구니 갱신하기
    }

    @DeleteMapping("/cartId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value="cartId") String cartId){
        cartService.deleteAll(cartId);
    }

}
